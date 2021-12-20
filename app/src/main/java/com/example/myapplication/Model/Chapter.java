package com.example.myapplication.Model;

import java.io.Serializable;

public class Chapter {

    private String name;

    public Chapter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
