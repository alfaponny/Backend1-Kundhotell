package com.example.backenend1kundhotell.models;

public enum RoomType {
    SINGLE("Enkelrum"),
    DOUBLE("Dubbelrum");

    private final String displayName;

    RoomType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
