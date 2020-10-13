package com.example.demo.services;

import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.exceptions.ResponseNotFoundException;
import com.example.demo.model.Response;
import com.example.demo.repository.ResponseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Response Service
 */
@Service
public class ResponseServiceImpl implements ResponseService {

    private static final Logger logger = LoggerFactory.getLogger(ResponseServiceImpl.class);

    @Autowired
    ResponseRepository responseRepository;

    /**
     * To create a response on form
     * @param response
     * @return response object
     */
    @Override
    public Response create(Response response)
    {
        if(logger.isDebugEnabled())
        {
            logger.info("Created a new response");
        }
        return responseRepository.save(response);
    }

    /**
     * To update a response
     * @param response
     * @return
     */
    @Override
    public Response update(Response response)
    {
        if(logger.isDebugEnabled())
        {
            logger.info("Updated the response");
        }
        return responseRepository.save(response);
    }

    /**
     * To get all response available on particular form
     * @param formid
     * @return List<Response>
     */
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
        if(ans.isEmpty())
        {
            throw new ResponseNotFoundException();
        }
        return ans;
    }
}
