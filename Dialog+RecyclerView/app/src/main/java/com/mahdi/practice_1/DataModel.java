package com.mahdi.practice_1;

public class DataModel {
    private String name;
    private int age;
    private String image;

    public DataModel(String name, int age, String image) {
        this.name = name;
        this.age = age;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getImage() {
        return image;
    }
}
