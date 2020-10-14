package com.example.demo.services;

import com.example.demo.dto.edit.EditRespDto;
import com.example.demo.dto.mapper.ResponseMapper;
import com.example.demo.dto.model.ResponseDto;
import com.example.demo.exceptions.ResponseNotFoundException;
import com.example.demo.model.Form;
import com.example.demo.model.Response;
import com.example.demo.model.resp;
import com.example.demo.repository.FormRepository;
import com.example.demo.repository.ResponseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ResponseService {

    private ResponseRepository responseRepository;

    private FormRepository formRepository;

    /**
     * Create response on given form_id
     * @param id
     * @param response
     * @return
     */
    public ResponseDto create(String id, EditRespDto response)
    {
        Form f= formRepository.findByformid(id);
        List<resp> arr = response.getResp_list();
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getType().toString().equals("MCQ"))
            {
                ArrayList<String> optns = f.getQstn_list().get(i).getOptions();
                for(int j=0;j<optns.size();j++)
                {
                    if(arr.get(i).getAns().equals(optns.get(i)))
                    {
                        arr.get(i).setAns(String.valueOf(j));
                        break;
                    }
                }
            }
        }
        response.setResp_list(arr);
        return ResponseMapper.ResponsetoResponseDto(responseRepository.save(ResponseMapper.ResponseDtoToResponse(response)));
    }

    public List<ResponseDto> getall(String formid) throws ResponseNotFoundException
    {
        List<Response> tmp = new ArrayList<>(responseRepository.findAll());
        List<ResponseDto> ans = new ArrayList<>();

        for(Response f:tmp)
        {
            ResponseDto resp = ResponseMapper.ResponsetoResponseDto(f);
            if(resp.getFormid().equals(formid))
            {
                ans.add(resp);
            }
        }
        if(ans.isEmpty())
        {
            throw new ResponseNotFoundException();
        }
        return ans;

    }
}
