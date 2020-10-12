package com.example.demo.model;

import com.example.demo.model.Form;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.ArrayList;

/**
 * Represents a response object
 */
@Getter @Setter @NoArgsConstructor
public class Response {


    @Indexed
    private String form_id;
    private String user_id;

    // List of answers of all questions for provided form_id
    private ArrayList<resp> arr;

    /**
     * Creates a response with specified values
     * @param f_id
     * @param u_id
     * @param arr
     */
    public Response(String f_id,String u_id, ArrayList<resp> arr)
    {
        this.form_id=f_id;
        this.user_id=u_id;
        this.arr=new ArrayList<>(arr);
    }

    /**
     * Gets the current response's user_id
     * @return String representing the user_id
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * Sets user_id for current response
     * @param user_id
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     * Get the current response's form_id
     * @return String representing the form_id
     */
    public String getForm_id() {
        return form_id;
    }

    /**
     * Sets form id for current response
     * @param form_id
     */
    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    /**
     * List of answer of quesions for given form id
     * @return List of answer object
     */
    public ArrayList<resp> getArr() {
        return arr;
    }

    /**
     * Sets list of answers for given form_id
     * @param arr
     */
    public void setArr(ArrayList<resp> arr) {
        this.arr = arr;
    }

    /**
     * Gives details of particular response object
     * @return String representing all details of particular response object
     */
    @Override
    public String toString() {
        return "Response{" +
                ", form_id='" + form_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", arr=" + arr +
                '}';
    }
}
