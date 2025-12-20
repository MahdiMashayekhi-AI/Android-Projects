package com.mahdi.presonalinfoapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class UserModel implements Parcelable {
    String name, family, phone;
    int age;

    public UserModel(String name, String family, String phone, int age) {
        this.name = name;
        this.family = family;
        this.phone = phone;
        this.age = age;
    }

    protected UserModel(Parcel in) {
        name = in.readString();
        family = in.readString();
        phone = in.readString();
        age = in.readInt();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(family);
        dest.writeString(phone);
        dest.writeInt(age);
    }
}
