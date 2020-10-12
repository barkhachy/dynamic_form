package com.example.demo.model;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.Qtype;
import java.util.*;

public class Questions {

    private Qtype type;
    private String qstn;
    private ArrayList<String> options;
    public Questions(){
    }

    public Questions(Qtype type,String heading)
    {
         this.type= type;
         this.qstn = heading;
    }
    public Questions(Qtype type,String heading, ArrayList<String> optns)
    {
        this.type=type;
        this.qstn = heading;
        options = new ArrayList<>(optns);
    }

    @Override
    public String toString() {
        return "Questions{" +
                ", type=" + type +
                ", qstn='" + qstn + '\'' +
                ", options=" + options +
                '}';
    }


}//mongocopass
//lombok
