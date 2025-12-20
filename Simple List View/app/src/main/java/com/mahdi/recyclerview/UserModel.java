package com.mahdi.recyclerview;

public class UserModel {

    private String name;
    private String phone;
    private int imageId;

    public UserModel(String name, String phone, int imageId) {
        this.name = name;
        this.phone = phone;
        this.imageId = imageId;
    }

    public String getName() {return name;}
    public String getPhone() {return phone;}
    public int getImageId() {return imageId;}
}
