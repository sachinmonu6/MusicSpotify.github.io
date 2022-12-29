package com.niit.Authentication.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String emailid;
    @GeneratedValue
    private int userid;
    private String  password,role;

    public User() {
    }

    public User(String emailid, int userid, String password, String role) {
        this.emailid = emailid;
        this.userid = userid;
        this.password = password;
        this.role = role;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "emailid='" + emailid + '\'' +
                ", userid=" + userid +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
