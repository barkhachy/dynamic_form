package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.stream.Stream;

/**
 * Question type that can be used
 */
public enum Qtype{

    MCQ("MCQ"),
    TEXT("TEXT"),
    DATE("DATE");


    private String type;
    private Qtype(String type)
    {
        this.type=type;
    }

    @JsonCreator
    public static Qtype decode(final String type)
    {
        return Stream.of(Qtype.values()).filter(targetEnum -> targetEnum.type.equals(type)).findFirst().orElse(null);
    }

    @JsonValue
    public String getType()
    {
        return type;
    }

}
