package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.dto.edit.EditRespDto;
import com.example.demo.dto.model.ResponseDto;
import com.example.demo.model.resp;
import com.example.demo.utils.Qtype;
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
public class testResponseController {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    /**
     * To test post request for response
     */
    @Test
    public void testCreateResponse() throws AssertionError
    {
        resp r1 = new resp(Qtype.MCQ,"less than 1");
        List<resp> arr = new ArrayList<>();
        arr.add(r1);
        EditRespDto responseDto = new EditRespDto("5f85f44cc8425751f64b063c","abc",arr);
        HttpEntity<EditRespDto> entity = new HttpEntity<EditRespDto>(responseDto,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(create("/forms/5f85f44cc8425751f64b063c"), HttpMethod.POST,entity,String.class);

        String act = responseEntity.getBody();
        System.out.println(act);
        Assert.assertTrue(act.contains("response created"));
    }

    /**
     * To create url
     * @param uri
     * @return
     */
    private String create(String uri)
    {
        return "http://localhost:" + port + uri;
    }
}
