package com.example.finalprojectapp.models;

import android.os.Parcelable;

public class People{

    int id;
    String name;
    String tel;
    String address;
    String note;
    Boolean fav;
    int hairColor;
    int progLang;


    public People() {}

    public People(String name, String tel, String address, String note, Boolean fav, int hairColor,
                  int progLang) {
        super();
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.note = note;
        this.fav = fav;
        this.hairColor = hairColor;
        this.progLang = progLang;
    }

    public People(int id, String name, String tel, String address, String note, Boolean fav, int hairColor,
                  int progLang) {
        super();
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.note = note;
        this.fav = fav;
        this.hairColor = hairColor;
        this.progLang = progLang;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getFav() {
        return fav;
    }

    public void setFav(Boolean fav) {
        this.fav = fav;
    }

    public int getHairColor() {
        return hairColor;
    }

    public void setHairColor(int hairColor) {
        this.hairColor = hairColor;
    }

    public int getProgLang() {
        return progLang;
    }

    public void setProgLang(int progLang) {
        this.progLang = progLang;
    }

    @Override
    public String toString() {
        return getName();
    }
}
