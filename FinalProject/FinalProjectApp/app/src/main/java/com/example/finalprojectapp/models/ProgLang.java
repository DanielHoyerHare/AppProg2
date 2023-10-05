package com.example.finalprojectapp.models;

public class ProgLang {

    int id;
    String lang;


    public ProgLang() {}

    public ProgLang(String lang) {
        super();
        this.lang = lang;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}

