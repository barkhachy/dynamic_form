package com.example.demo.Controller;

import com.example.demo.dto.Responsedto;
import com.example.demo.dto.edit.EditFormDto;
import com.example.demo.dto.edit.EditRespDto;
import com.example.demo.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @PostMapping(value="form/{id}")
    ResponseEntity<Responsedto> createResp(@RequestBody EditRespDto resp, @PathVariable(value="id") String id)
    {
        Responsedto ans = new Responsedto((HttpStatus.OK.toString()),"response created",responseService.create(id,resp));
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }


    @GetMapping(value="form/{id}/resp")
    ResponseEntity<Responsedto> getall(@PathVariable(value="id") String id)
    {
        Responsedto ans = new Responsedto(HttpStatus.OK.toString(), "all responses", responseService.getall(id));
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }
}
