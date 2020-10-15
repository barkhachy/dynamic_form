package com.example.demo.service;

import com.example.demo.dto.edit.EditFormDto;
import com.example.demo.dto.edit.EditUserDto;
import com.example.demo.dto.model.FormDto;
import com.example.demo.dto.model.UserDto;
import com.example.demo.exceptions.FormNotFoundException;
import com.example.demo.model.Questions;
import com.example.demo.repository.FormRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.FormService;
import com.example.demo.services.UserService;
import com.example.demo.utils.Qtype;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@DirtiesContext
public class FormServiceIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private FormService formService;

    @Test
    public void testCreateGetUpdateDeleteForm()
    {
        UserDto userDto = userService.createUser(new EditUserDto("Barkha","barkha11199@gmail.com"));

        // *** creating the form
        EditFormDto editFormDto = new EditFormDto(userDto.getId(),getForms());
        FormDto formDto = formService.createForm(editFormDto);

        // *** Get
        List<FormDto> form = formService.getallForms(userDto.getId());
        Assert.assertEquals(form.size(),1);

        Assert.assertEquals(formDto.getUid(),userDto.getId());

        // *** Update
        EditFormDto editFormDto1 = new EditFormDto("abcd123", getForms());
        FormDto formDto1 = formService.update(formDto.getFormid(), editFormDto1);
        Assert.assertEquals("abcd123",formDto1.getUid());

        // *** Delete
        boolean flag=true;
        formService.delete(formDto1.getFormid());
        try{
            Assert.assertEquals(formService.getform(formDto.getFormid()),null);
        }
        catch(FormNotFoundException ex)
        {
            flag = false;
        }
        Assert.assertEquals(flag,false);

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

}
