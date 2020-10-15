package com.example.demo.service;

import com.example.demo.dto.edit.EditFormDto;
import com.example.demo.dto.edit.EditRespDto;
import com.example.demo.dto.edit.EditUserDto;
import com.example.demo.dto.model.FormDto;
import com.example.demo.dto.model.ResponseDto;
import com.example.demo.dto.model.UserDto;
import com.example.demo.model.Questions;
import com.example.demo.model.resp;
import com.example.demo.repository.FormRepository;
import com.example.demo.repository.ResponseRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.FormService;
import com.example.demo.services.ResponseService;
import com.example.demo.services.UserService;
import com.example.demo.utils.Qtype;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@DirtiesContext
public class ResponseServiceIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private FormService formService;

    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private ResponseService responseService;

    @Test
    public void responseTest()
    {

        UserDto userDto = userService.createUser(new EditUserDto("Barkha","barkha11199@gmail.com"));
        EditFormDto editFormDto = new EditFormDto(userDto.getId(),getForms());
        FormDto formDto = formService.createForm(editFormDto);

        // *** CREATE
        EditRespDto responseDto = new EditRespDto(formDto.getFormid(),userDto.getId(),getresp());
        responseService.create(formDto.getFormid(),responseDto);

        // *** GET
        List<ResponseDto> arr = responseService.getall(formDto.getFormid());
        Assert.assertEquals(userDto.getId(),arr.get(0).getUserid());


    }

    /**
     * To create a list of questions
     * @return
     */
    private List<Questions> getForms()
    {
        Questions q1 = new Questions(Qtype.TEXT,"Current Address",null);
        Questions q2 = new Questions(Qtype.DATE, "Date of Birth",null);
        List<Questions> ans = new ArrayList<>();
        ans.add(q1);
        ans.add(q2);
        return ans;
    }

    /**
     * To create a response
     * @return
     */
     private List<resp> getresp()
     {
         resp r1=new resp( Qtype.TEXT,"Dhanbad");
         resp r2=new resp(Qtype.DATE,new Date().toString());
         List<resp> ans = new ArrayList<>();
         ans.add(r1);
         ans.add(r2);
         return ans;
     }
}
