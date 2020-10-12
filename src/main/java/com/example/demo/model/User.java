package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

/** Represents an User
 *
 */
@Document
public class User
{
    @Id
    private String id;
    private String name;
    private String e_mail;

    /**
     * Creates a user with specified details
     * @param name
     * @param e_mail
     */
    public User(String name,String e_mail)
    {
        this.name=name;
        this.e_mail=e_mail;
    }

    /**
     * Gets the user's id
     * @return A string representaion of user's id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the user's id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the user's email address
     * @return A String representing the user's email address
     */
    public String getE_mail() {
        return e_mail;
    }

    /**
     * Sets the user's email address
     * @param e_mail
     */
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    /**
     * Gets the user's name
     * @return A String representing the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Compares one user with another
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(e_mail, user.e_mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, e_mail);
    }

    /**
     * Gives the user's details
     * @return A String representating the user details
     */
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", e_mail='" + e_mail + '\'' +
                '}';
    }


}