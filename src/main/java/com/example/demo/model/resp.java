package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor
public class resp {

    private Qtype type;
    private String ans;

    public resp(Qtype t,String ans)
    {
        this.type = t;
        this.ans = ans;
    }

    @Override
    public String toString() {
        return "resp{" +
                "type=" + type +
                ", ans='" + ans + '\'' +
                '}';
    }
}
