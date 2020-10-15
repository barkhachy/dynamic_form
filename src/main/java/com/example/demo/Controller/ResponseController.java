package com.example.demo.Controller;

import com.example.demo.dto.Responsedto;
import com.example.demo.dto.edit.EditFormDto;
import com.example.demo.dto.edit.EditRespDto;
import com.example.demo.exceptions.FormNotFoundException;
import com.example.demo.exceptions.ResponseNotFoundException;
import com.example.demo.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    /**
     * To create a response on given form id
     * @param resp
     * @param id
     * @return
     * @throws FormNotFoundException --> When form with given id is not found
     */
    @PostMapping(value="forms/{id}")
    public ResponseEntity<Responsedto> createResp(@Valid @RequestBody EditRespDto resp, @PathVariable(value="id") String id) throws FormNotFoundException
    {
        Responsedto ans = new Responsedto((HttpStatus.OK.toString()), "response created", responseService.create(id, resp));
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }


    /**
     * To get list of response made on particular form
     * @param id
     * @return
     * @throws FormNotFoundException --> When form is not found
     */
    @GetMapping(value="forms/{id}/resp")
    public ResponseEntity<Responsedto> getall(@PathVariable(value="id") String id) throws FormNotFoundException,ResponseNotFoundException
    {
        Responsedto ans = new Responsedto(HttpStatus.OK.toString(), "all responses", responseService.getall(id));
        return new ResponseEntity<>(ans, HttpStatus.OK);

    }
}
