package com.example.demo.services;

import com.example.demo.model.Response;
import com.example.demo.repository.ResponseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {

    private static final Logger logger = LoggerFactory.getLogger(ResponseServiceImpl.class);

    @Autowired
    ResponseRepository responseRepository;

    @Override
    public Response create(Response response)
    {
        if(logger.isDebugEnabled())
        {
            logger.info("Created a new response");
        }
        return responseRepository.save(response);
    }

    @Override
    public Response update(Response response)
    {
        if(logger.isDebugEnabled())
        {
            logger.info("Updated the response");
        }
        return responseRepository.save(response);
    }

    @Override
    public List<Response> all(String formid)
    {
        ArrayList<Response> ans = new ArrayList<>();
        ArrayList<Response> tmp = new ArrayList<>(responseRepository.findAll());
        for(Response a:tmp)
        {
            if(a.getForm_id().equals(formid)) {
                ans.add(a);
            }
        }
        return ans;
    }
}