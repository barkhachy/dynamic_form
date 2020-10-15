package com.example.demo.services;

import com.example.demo.dto.edit.EditFormDto;
import com.example.demo.dto.mapper.FormMapper;
import com.example.demo.dto.model.FormDto;
import com.example.demo.exceptions.FormNotFoundException;
import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.Form;
import com.example.demo.repository.FormRepository;
import com.example.demo.utils.Qtype;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

/**
 * Service class of Form
 */
@Service
@AllArgsConstructor
public class FormService {


    private FormRepository formRepository;

    public List<FormDto> getallForms(String id) throws NoDataFoundException, FormNotFoundException
    {
        List<Form> arr = new ArrayList<>(formRepository.findAll());
        List<FormDto> ans = new ArrayList<>();
        for(Form f:arr)
        {
            FormDto tmp = FormMapper.FormToFormDto(f);
            if(tmp.getUid().equals(id))
            {
                ans.add(tmp);
            }
        }
        if(ans.isEmpty())
        {
                throw new NoDataFoundException();
        }
        return ans;
    }

    /**
     * Create form
     * @param form
     * @return
     */
    public FormDto createForm(EditFormDto form)
    {
        return FormMapper.FormToFormDto(formRepository.save(FormMapper.FormDtoToForm(form)));
    }

    /**
     * To get a form with given id
     * @param id
     * @return
     * @throws FormNotFoundException
     */
    public FormDto getform(String id) throws FormNotFoundException
    {
        Form form = formRepository.findByformid(id);
        if(form==null)
        {
            throw new FormNotFoundException(id);
        }
        return FormMapper.FormToFormDto(form);
    }

    /**
     * To update a form
     * @param id
     * @param form
     * @return
     * @throws FormNotFoundException
     */
    public FormDto update(String id, EditFormDto form) throws FormNotFoundException
    {
        Form form1 = formRepository.findByformid(id);
        if(form1==null)
        {
            throw new FormNotFoundException(id);
        }
        Form tmp = FormMapper.FormDtoToForm(form);
        if(tmp.getUid()!=null)
        {
            form1.setUid(tmp.getUid());
        }
        if(!tmp.getQstn_list().isEmpty())
        {
            form1.setQstn_list(new ArrayList<>(form.getQstn_list()));
        }
        return FormMapper.FormToFormDto(form1);
    }

    /**
     * To delete a form
     * @param id
     * @return
     * @throws FormNotFoundException
     */
    public String delete(String id) throws FormNotFoundException
    {
        Form form = formRepository.findByformid(id);
        if(form == null)
        {
            throw new FormNotFoundException(id);
        }
        formRepository.deleteById(id);
        return "";
    }

    /**
     * To get list of Question type
     * @return
     */

    public Qtype[] getOptns()
    {
        return Qtype.values();
    }

}
