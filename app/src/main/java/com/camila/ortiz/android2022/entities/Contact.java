package com.camila.ortiz.android2022.entities;

public class Contact {

    public int id;
    public String name;
    public String number;

    public Contact(String name, String number){
        this.name=name;
        this.number = number;
    }

    public Contact (int id, String name, String number){
        this.id = id;
        this.name = name;
        this.number = number;
    }

}
