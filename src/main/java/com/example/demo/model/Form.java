package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;
import java.util.Objects;

@Document
public class Form {

    @Id
    private String form_id;
    private String u_id;

    ArrayList <Questions> qstn_list = new ArrayList<>();

    public Form(){

    }
    public Form(String id,ArrayList<Questions> qstns)
    {
        this.u_id=id;
        this.qstn_list = qstns;
    }


    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }


    public ArrayList<Questions> getQstn_list() {
        return qstn_list;
    }

    public void setQstn_list(ArrayList<Questions> qstn_list) {
        this.qstn_list = qstn_list;
    }

    @Override
    public String toString() {
        return "Form{" +
                "form_id='" + form_id + '\'' +
                "user_id=" + u_id + '\''+
                ", qstn_list=" + qstn_list +
                '}';
    }
}
