package com.example.demo.services;

import com.example.demo.model.Form;
import com.example.demo.repository.FormRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    private static final Logger logger= LoggerFactory.getLogger(FormServiceImpl.class);

    @Autowired
    FormRepository formRepository;

    @Override
    public Form create(Form form)
    {
        if(logger.isDebugEnabled())
        {
            logger.info("Creating the form");
        }
        return formRepository.save(form);
    }

    @Override
    public Form findByformid(String formid)
    {
        if(logger.isDebugEnabled())
        {
            logger.info("Finding form for given form_id");
        }
        return formRepository.findByformid(formid);
    }

    @Override
    public Form findByuid(String uid)
    {
        if(logger.isDebugEnabled())
        {
            logger.info("Finding form for given user");
        }
        return formRepository.findByuid(uid);
    }

    @Override
    public List<Form> findall()
    {
        if(logger.isDebugEnabled())
        {
            logger.info("Find all forms been created");
        }
        return formRepository.findAll();
    }

    @Override
    public Form update(Form form)
    {
        if(logger.isDebugEnabled())
        {
            logger.info("Update the form");
        }
        return formRepository.save(form);
    }

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
