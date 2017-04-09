package com.example.jyw.expandablerecyclerview.model;

/**
 * Created by JYW on 2017-03-19 019.
 */

public class Child extends Node {
    private int imgUrl;
    private String name;
    private String position;
    private String group;

    public Child(int imgUrl, String name, String position, String group) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.position = position;
        this.group = group;
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getGroup() {
        return group;
    }
}
