package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.dto.edit.EditFormDto;
import com.example.demo.model.Questions;
import com.example.demo.utils.Qtype;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testFormController {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    private HttpHeaders headers = new HttpHeaders();

    /**
     * To test get request form
     * @throws AssertionError
     * @throws JSONException
     */
    @Test
    public void testFormDetails() throws AssertionError, JSONException
    {
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(create("/forms/5f87e3149529ef3ec94cba8f"), HttpMethod.GET,entity, String.class);
        String act = responseEntity.getBody();
        System.out.println(act);
        Assert.assertTrue(act.contains("Form not found"));
    }

    private String create(String uri)
    {
        return "http://localhost:" + port + uri;
    }

    /**
     * To test post request for form
     */
    @Test
    public void testCreateForm()
    {
        Questions q1 = new Questions(Qtype.DATE,"DOB",null);
        List<Questions> arr = new ArrayList<>();

        EditFormDto formDto = new EditFormDto("5f7feeb8c1f52d2613e4fd98",arr);
        HttpEntity<EditFormDto> entity=new HttpEntity<>(formDto ,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(create("/forms/add"), HttpMethod.POST,entity,String.class);

        String act = responseEntity.getBody();
        Assert.assertTrue(act.contains("form created"));

    }

    @Test
    public void testUpdateForm()
    {
        Questions q1 = new Questions(Qtype.TEXT,"Permanent Address",null);
        List<Questions> arr = new ArrayList<>();

        HttpEntity<EditFormDto> entity=new HttpEntity<>(new EditFormDto("abcd",arr) ,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(create("/forms/5f87f53ec145da71571c9547"), HttpMethod.PUT,entity,String.class);

        String act = responseEntity.getBody();
        System.out.println(act+" "+"here");
        Assert.assertTrue(act.contains("abcd"));

    }

    @Test
    public void testDeleteForm()
    {
        HttpEntity<String> entity=new HttpEntity<>(null ,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(create("/forms/5f87f53ec145da71579547"), HttpMethod.DELETE,entity,String.class);

        String act = responseEntity.getBody();
        Assert.assertTrue(act.contains("Form not found"));

    }


}
