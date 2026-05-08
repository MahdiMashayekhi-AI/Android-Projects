package com.mahdi.practice_3;

public class MusicItem {
    private String title;
    private int resId;

    public MusicItem(String title, int resId) {
        this.title = title;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public int getResId() {
        return resId;
    }
}
