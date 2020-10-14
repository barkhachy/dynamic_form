package com.example.demo.dto.mapper;


import com.example.demo.dto.edit.EditRespDto;
import com.example.demo.dto.model.ResponseDto;
import com.example.demo.model.Response;

public class ResponseMapper {

    public static ResponseDto ResponsetoResponseDto(Response resp)
    {
        return new ResponseDto(resp.getFormid(), resp.getUserid(), resp.getArr());
    }

    public static Response ResponseDtoToResponse(EditRespDto resp)
    {
        return new Response(resp.getFormid(), resp.getUid(), resp.getResp_list());
    }
}
