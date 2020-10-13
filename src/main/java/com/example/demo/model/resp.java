package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a answer
 */
@Getter@Setter@NoArgsConstructor
public class resp {

    private Qtype type;
    private String ans;

    /**
     * Creates a answer with specified values
     * @param t
     * @param ans
     */
    public resp(Qtype t,String ans)
    {
        this.type = t;
        this.ans = ans;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Qtype getType() {
        return type;
    }

    public void setType(Qtype type) {
        this.type = type;
    }

    /**
     * Gives details of particular answer
     * @return String representation of answer
     */
    @Override
    public String toString() {
        return "resp{" +
                "type=" + type +
                ", ans='" + ans + '\'' +
                '}';
    }
}
