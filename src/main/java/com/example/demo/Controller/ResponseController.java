package com.example.demo.Controller;

import com.example.demo.model.Form;
import com.example.demo.model.Response;
import com.example.demo.model.resp;
import com.example.demo.services.FormService;
import com.example.demo.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @Autowired
    private FormService formService;

    /**
     * To get list of responses made on particular form
     * @param form_id
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="form/{form_id}/responses", method = RequestMethod.GET)
    public List<Response> all_resp(@PathVariable(value="form_id") String form_id)
    {
        ArrayList<Response> ans = new ArrayList<>(responseService.all(form_id));
        return ans;
    }


    /**
     * To create response on a form
     * @param response
     * @param form_id
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="form/{form_id}", method = RequestMethod.POST)
    public String get_form(@RequestBody Response response, @PathVariable(value="form_id") String form_id)
    {
        Form f = formService.findByformid(form_id);
        ArrayList<resp> arr = response.getArr();
        //System.out.println("what's is happening");
        for(int i=0;i<arr.size();i++)
        {
           // System.out.println(arr.get(i).getType());
            if(arr.get(i).getType().toString().equals("MCQ"))
            {
                //System.out.println("Its mcq");
                ArrayList<String> optns = f.getQstn_list().get(i).getOptions();
                //System.out.println(f.getQstn_list().get(i).getQstn());
                //System.out.println(f.getQstn_list().get(i).getOptions());
                //System.out.println(optns);
                for(int j=0;j<optns.size();j++)
                {
                    if(arr.get(i).getAns().equals(optns.get(j)))
                    {
                        arr.get(i).setAns(String.valueOf(j));
                        //System.out.println(arr.get(i).getAns());
                        break;
                    }
                }
            }
        }
        response.setArr(arr);
        responseService.create(response);
        return "Okk!!";
    }
}
