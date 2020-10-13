package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;
import java.util.Objects;

/**
 * Represents a form
 */
@Document
public class Form {

    @Id
    private String formid;

    //ArrayList of question object
    ArrayList <Questions> qstn_list = new ArrayList<>();

    public Form(){

    }
    private String uid;
    /**
     * Creates a form with specified values
     * @param id
     * @param qstns
     */
    public Form(String id,ArrayList<Questions> qstns)
    {
        this.uid=id;
        this.qstn_list = qstns;
    }

    /**
     * Gets the form_id of particular form
     * @return String representing the form_id
     */
    public String getFormid() {
        return formid;
    }

    /**
     * Sets the form_id
     * @param form_id
     */

    public void setFormid(String form_id) {
        this.formid = form_id;
    }

    /**
     * Gets the user id of owner of form
     * @return String representing the form's user id
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the user id of form's owner
     * @param u_id
     */
    public void setUid(String u_id) {
        this.uid = u_id;
    }

    /**
     * Gets the list of question's of given form
     * @return Object representaion of all questions
     */
    public ArrayList<Questions> getQstn_list() {
        return qstn_list;
    }

    /**
     * Sets the question list for given form
     * @param qstn_list
     */
    public void setQstn_list(ArrayList<Questions> qstn_list) {
        this.qstn_list = qstn_list;
    }

    /**
     * Gives the form details
     * @return String representing all details of particular form
     */
    @Override
    public String toString() {
        return "Form{" +
                "form_id='" + formid + '\'' +
                "user_id=" + uid + '\''+
                ", qstn_list=" + qstn_list +
                '}';
    }
}
