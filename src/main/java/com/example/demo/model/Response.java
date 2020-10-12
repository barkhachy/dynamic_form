package com.example.demo.model;

import com.example.demo.model.Form;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.ArrayList;

@Getter @Setter @NoArgsConstructor
public class Response {

    @Indexed
    private String form_id;
    private String user_id;
    private ArrayList<resp> arr;

    public Response(String f_id,String u_id, ArrayList<resp> arr)
    {
        this.form_id=f_id;
        this.user_id=u_id;
        this.arr=new ArrayList<>(arr);
    }

    @Override
    public String toString() {
        return "Response{" +
                ", form_id='" + form_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", arr=" + arr +
                '}';
    }
}
