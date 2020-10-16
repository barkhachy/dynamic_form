package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.dto.edit.EditUserDto;
import com.example.demo.model.User;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

/**
 * To perform test on User Controller
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testUserController {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    private HttpHeaders headers = new HttpHeaders();

    /**
     * To perform the get operation
     * @throws AssertionError
     * @throws JSONException
     */
    @Test
    public void testUserDetails() throws AssertionError, JSONException {

        HttpEntity<String> entity=new HttpEntity<String>(null,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(create("/users/5f882d3b0453a6344657ec"), HttpMethod.GET,entity,String.class);

        String act = responseEntity.getBody();
        Assert.assertTrue(act.contains("BAD_REQUEST"));

    }
    private String create(String uri)
    {
        return "http://localhost:" + port + uri;
    }

    /**
     * To perform the post operation
     */
    @Test
    public void testAddUser()
    {
        EditUserDto user = new EditUserDto("abc","");

        HttpEntity<EditUserDto> entity = new HttpEntity<>(user, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(create("/users/add"),HttpMethod.POST,entity,String.class);

        String tmp = responseEntity.getBody();
        System.out.println(tmp);
        Assert.assertTrue(tmp.contains("created new User"));

    }

    /**
     * To test api for updating the user
     */
    @Test
    public void testUpdateUser() throws AssertionError
    {
        EditUserDto user = new EditUserDto("Barkha Kumari Chy","");

        HttpEntity<EditUserDto> entity = new HttpEntity<>(user,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(create("users/5f7feebc1f52d2613e4fd98"),HttpMethod.PUT,entity,String.class);

        String tmp = responseEntity.getBody();
        Assert.assertTrue(tmp.contains("BAD_REQUEST"));

    }

    @Test
    public void testDeleteUser() throws AssertionError
    {
        HttpEntity<EditUserDto> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(create("users/5f7feeb8c1f52d2613e4fd98"),HttpMethod.DELETE,entity,String.class);

        String tmp = responseEntity.getBody();
        Assert.assertTrue(tmp.contains("BAD_REQUEST"));

    }

}