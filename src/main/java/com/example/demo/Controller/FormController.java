package com.example.demo.Controller;

import com.example.demo.dto.Responsedto;
import com.example.demo.dto.edit.EditFormDto;
import com.example.demo.exceptions.FormNotFoundException;
import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.exceptions.ResponseNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value="/forms")
public class FormController {

    @Autowired
    private FormService formService;

    /**
     * To get all the forms created by user with user_id as id
     * @param id
     * @return
     * @throws UserNotFoundException --> When user is not found
     * @throws NoDataFoundException --> When form is created by given id(user_id)
     */
    @GetMapping(value="/{id}/all")
    public ResponseEntity<Responsedto> getallforms(@PathVariable(value="id") String id) throws UserNotFoundException, NoDataFoundException
    {

            Responsedto ans = new Responsedto(HttpStatus.OK.toString(), "all forms created by me", formService.getallForms(id));
            return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    /**
     * To create a form
     * @param form
     * @return
     */
    @PostMapping(value = "/add")
    public ResponseEntity<Responsedto> create(@Valid @RequestBody EditFormDto form) throws MethodArgumentNotValidException
    {
        Responsedto ans = new Responsedto((HttpStatus.OK.toString()),"form created", formService.createForm(form));
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    /**
     * To get a form with given id
     * @param id
     * @return
     * @throws FormNotFoundException --> When form is not found
     */
    @GetMapping(value="/{id}")
    public ResponseEntity<Responsedto> getform(@PathVariable(value="id") String id) throws FormNotFoundException
    {
        Responsedto ans = new Responsedto(HttpStatus.OK.toString(), "", formService.getform(id));
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    /**
     * To update a form
     * @param id
     * @param form
     * @return
     * @throws FormNotFoundException --> When form is not found
     */
    @PutMapping(value="/{id}")
    public ResponseEntity<Responsedto> updateform(@PathVariable(value="id") String id, @RequestBody EditFormDto form) throws FormNotFoundException
    {
<<<<<<< HEAD
        Responsedto ans = new Responsedto(HttpStatus.OK.toString(), "", formService.update(id,form));
=======
        Responsedto ans = new Responsedto(HttpStatus.OK.toString(), "", formService.getform(id));
>>>>>>> 4035bc97aec59c5839e4a69fe187a6e77b0cce85
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    /**
     * To delete a form
     * @param id
     * @return
     * @throws FormNotFoundException --> When form is not found
     */
    @DeleteMapping(value="{id}")
    ResponseEntity<Responsedto> deleteform(@PathVariable(value="id") String id) throws FormNotFoundException
    {
        Responsedto ans = new Responsedto(HttpStatus.OK.toString(), "", formService.delete(id));
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    /**
     * To get list of available types of questions
     * @return
     */
    @GetMapping(value = "/get_optns")
    ResponseEntity<Responsedto> getOptns()
    {
        Responsedto ans = new Responsedto(HttpStatus.OK.toString(), "qstns options", formService.getOptns());
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

}
