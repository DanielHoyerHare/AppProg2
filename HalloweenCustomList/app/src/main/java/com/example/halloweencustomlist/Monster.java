package com.example.halloweencustomlist;

import android.graphics.drawable.Drawable;

public class Monster {
    String name;
    String description;
    int imgId;

    public Monster(String name, String description, int imgId) {
        this.name = name;
        this.description = description;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
