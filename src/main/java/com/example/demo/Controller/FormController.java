package com.example.demo.Controller;

import com.example.demo.dto.Responsedto;
import com.example.demo.dto.edit.EditFormDto;
import com.example.demo.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/forms")
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping(value="/{id}/all")
    ResponseEntity<Responsedto> getallforms(@PathVariable(value="id") String id)
    {
        Responsedto ans = new Responsedto(HttpStatus.OK.toString(), "all forms created by me", formService.getallForms(id));
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    ResponseEntity<Responsedto> create(@RequestBody EditFormDto form)
    {
        Responsedto ans = new Responsedto((HttpStatus.OK.toString()),"form created", formService.createForm(form));
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    ResponseEntity<Responsedto> getform(@PathVariable(value="id") String id)
    {
        Responsedto ans = new Responsedto(HttpStatus.OK.toString(),"",formService.getform(id));
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @PutMapping(value="/{id}")
    ResponseEntity<Responsedto> updateform(@PathVariable(value="id") String id, @RequestBody EditFormDto form)
    {
        Responsedto ans = new Responsedto(HttpStatus.OK.toString(),"",formService.getform(id));
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @DeleteMapping(value="{id}")
    ResponseEntity<Responsedto> deleteform(@PathVariable(value="id") String id)
    {
        Responsedto ans = new Responsedto(HttpStatus.OK.toString(),"",formService.delete(id));
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @GetMapping(value = "/get_optns")
    ResponseEntity<Responsedto> getOptns()
    {
        Responsedto ans = new Responsedto(HttpStatus.OK.toString(), "qstns options", formService.getOptns());
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

}
