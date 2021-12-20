package com.example.myapplication.Model;

import android.widget.ImageView;

import java.io.Serializable;

public class Book implements Serializable {

    private String name;
    private int resourceID;

    public Book(String name, int resourceID) {
        this.name = name;
        this.resourceID = resourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }
}
