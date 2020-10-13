package com.example.demo.Controller;

import com.example.demo.model.Form;
import com.example.demo.model.Qtype;
import com.example.demo.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class FormController {

    @Autowired
    private FormService formService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="create_form", method = RequestMethod.GET)
    public Qtype[] gettype()
    {
        return Qtype.values();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="form", method = RequestMethod.POST)
    public String create(@RequestBody Form form)
    {
        Form f = formService.create(form);
        return "created";
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="form/{form_id}", method = RequestMethod.GET)
    public Form get_form(@PathVariable(value="form_id") String form_id)
    {
        Form f = formService.findByformid(form_id);
        return f;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="form/{form_id}", method = RequestMethod.PUT)
    public String update_form(@RequestBody Form form ,@PathVariable(value="form_id") String form_id)
    {
        Form f = formService.findByformid(form_id);
        if(f.getUid().equals(""))
        {
            Form updated_form= formService.update(form);
            return "Updated!!";
        }
        return "You can't update this form";
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "form/{form_id}", method = RequestMethod.DELETE)
    public String delete_form(@PathVariable(value="form_id") String form_id)
    {
        Form f = formService.findByformid(form_id);
        if(f.getUid().equals(""))
        {
            formService.delete(form_id);
            return "Deleted!!";
        }
        return "You can't delete this form";
    }

}
