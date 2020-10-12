package com.example.demo.model;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.Qtype;
import java.util.*;

/**
 * Represents a question
 */
public class Questions {

    private Qtype type;
    private String qstn;
    private ArrayList<String> options;
    public Questions(){
    }

    /**
     * Creates a question of type TEXT, date
     * @param type
     * @param heading
     */
    public Questions(Qtype type,String heading)
    {
         this.type= type;
         this.qstn = heading;
    }

    /**
     * Creates a question of MCQ type
     * @param type
     * @param heading
     * @param optns
     */
    public Questions(Qtype type,String heading, ArrayList<String> optns)
    {
        this.type=type;
        this.qstn = heading;
        options = new ArrayList<>(optns);
    }

    /**
     * Gives the type for given question
     * @return Enum Qtype
     */
    public Qtype getType() {
        return type;
    }

    /**
     * Sets the type of question
     * @param type
     */
    public void setType(Qtype type) {
        this.type = type;
    }

    /**
     * Gives list of options for given question
     * @return List of String
     */
    public ArrayList<String> getOptions() {
        return options;
    }

    /**
     * Sets options list for given question
     * @param options
     */
    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    /**
     * Gets the question heading
     * @return String
     */
    public String getQstn() {
        return qstn;
    }

    /**
     * Sets the heading of question
     * @param qstn
     */
    public void setQstn(String qstn) {
        this.qstn = qstn;
    }

    /**
     * Gives the details of particular question
     * @return String representation of question
     */
    @Override
    public String toString() {
        return "Questions{" +
                ", type=" + type +
                ", qstn='" + qstn + '\'' +
                ", options=" + options +
                '}';
    }


}
