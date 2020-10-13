package com.example.demo.services;

import com.example.demo.exceptions.FormNotFoundException;
import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.model.Form;
import com.example.demo.repository.FormRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Form Service
 */
@Service
public class FormServiceImpl implements FormService {

    private static final Logger logger= LoggerFactory.getLogger(FormServiceImpl.class);

    @Autowired
    FormRepository formRepository;

    /**
     * To create a form
     * @param form
     * @return Form object
     */
    @Override
    public Form create(Form form)
    {
        if(logger.isDebugEnabled())
        {
            logger.info("Creating the form");
        }
        return formRepository.save(form);
    }

    /**
     * To search for a form with provided formid
     * @param formid
     * @return Form object
     */
    @Override
    public Form findByformid(String formid)
    {
        if(logger.isDebugEnabled())
        {
            logger.info("Finding form for given form_id");
        }
        Form form = formRepository.findByformid(formid);
        if(form==null)
        {
            throw new FormNotFoundException(formid);
        }
        return form;
    }

    /**
     * Find a form created by particular user
     * @param uid
     * @return Form object
     */
    @Override
    public Form findByuid(String uid)
    {
        if(logger.isDebugEnabled())
        {
            logger.info("Finding form for given user");
        }
        Form form = formRepository.findByuid(uid);
        if(form==null)
        {
            throw new FormNotFoundException(uid);
        }
        return form;
    }

    /**
     * To get all forms
     * @return
     */
    @Override
    public List<Form> findall()
    {
        if(logger.isDebugEnabled())
        {
            logger.info("Find all forms been created");
        }
        List<Form> arr = formRepository.findAll();
        if(arr.isEmpty())
        {
            throw new NoDataFoundException();
        }
        return arr;
    }

    /**
     * To update a form
     * @param form
     * @return
     */
    @Override
    public Form update(Form form)
    {
        if(logger.isDebugEnabled())
        {
            logger.info("Update the form");
        }
        return formRepository.save(form);
    }

    /**
     * To delete a form with given form id
     * @param formid
     */
    @Override
    public void delete(String formid)
    {
        if(logger.isDebugEnabled())
        {
            logger.info("Delete the form");
        }
        formRepository.deleteById(formid);
    }
}
