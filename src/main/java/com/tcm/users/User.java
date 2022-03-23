package com.tcm.users;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "users")
public class User {

    @Id
    private String id = UUID.randomUUID().toString();
    private String email;
    private String password;
    private int gender;

    private static final int MALE = 1;
    private static final int FEMALE = 2;
    private static final int OTHERS = 3;

    public User() {

    }

    public User(String email, String password, int gender) throws Exception {
        checkEmail(email);
        checkPassword(password);
        checkGender(gender);
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        checkEmail(email);
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    private void checkEmail(String email) throws Exception {
        if (email.equals("")) throw new Exception();
    }

    private void checkPassword(String password) throws Exception {
        if (password.equals("")) throw new Exception();
    }

    private void checkGender(int gender) throws Exception {
        if (gender != MALE && gender != FEMALE && gender != OTHERS) throw new Exception();
    }

    public void setPassword(String password) throws Exception {
        checkPassword(password);
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) throws Exception {
        checkGender(gender);
        this.gender = gender;
    }
}
