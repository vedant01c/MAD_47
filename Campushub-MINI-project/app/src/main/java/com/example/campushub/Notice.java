package com.example.campushub;
public class Notice {
    public String title, date;
    public Notice() {} // Required for Firebase
    public Notice(String title, String date) {
        this.title = title;
        this.date = date;
    }
}