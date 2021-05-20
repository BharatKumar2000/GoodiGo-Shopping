package com.example.myapplication.main;

import java.util.List;

public class User {
    public String name;
    public String age;
    public String mail;
    public List<String> orderIds;

    public User() { }
    public User(String name,String age,String mail,List<String> orderIds) {
        this.name=name;
        this.age=age;
        this.mail=mail;
        this.orderIds=orderIds;
    }
    public List<String> getOrderIds(){return this.orderIds;}
    public String getName()
    {
        return this.name;
    }
    public String    getAge()
    {
        return this.age;
    }
    public String getMail()
    {
        return this.mail;
    }

    public void setName(String name)
    {
        this.name=name;
    }
    public void setAge(String age)
    {
        this.age=age;

    }
    public void setOrderIds(List<String> orderIds)
    {
        this.orderIds=orderIds;
    }
    public void setMail(String mail)
    {
        this.mail=mail;
    }
}


