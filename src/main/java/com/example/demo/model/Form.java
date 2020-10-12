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
    private String form_id;

    private String u_id;

    //ArrayList of question object
    ArrayList <Questions> qstn_list = new ArrayList<>();

    public Form(){

    }

    /**
     * Creates a form with specified values
     * @param id
     * @param qstns
     */
    public Form(String id,ArrayList<Questions> qstns)
    {
        this.u_id=id;
        this.qstn_list = qstns;
    }

    /**
     * Gets the form_id of particular form
     * @return String representing the form_id
     */
    public String getForm_id() {
        return form_id;
    }

    /**
     * Sets the form_id
     * @param form_id
     */

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    /**
     * Gets the user id of owner of form
     * @return String representing the form's user id
     */
    public String getU_id() {
        return u_id;
    }

    /**
     * Sets the user id of form's owner
     * @param u_id
     */
    public void setU_id(String u_id) {
        this.u_id = u_id;
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
                "form_id='" + form_id + '\'' +
                "user_id=" + u_id + '\''+
                ", qstn_list=" + qstn_list +
                '}';
    }
}
