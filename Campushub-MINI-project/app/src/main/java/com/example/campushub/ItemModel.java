package com.example.campushub;

public class ItemModel {
    public String itemName, location, description, status, contactInfo;

    public ItemModel() {} // Required for Firebase

    public ItemModel(String itemName, String location, String description, String status, String contactInfo) {
        this.itemName = itemName;
        this.location = location;
        this.description = description;
        this.status = status; // e.g., "Lost" or "Report Filed"
        this.contactInfo = contactInfo;
    }
}