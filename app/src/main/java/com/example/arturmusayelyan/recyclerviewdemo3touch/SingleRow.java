package com.example.arturmusayelyan.recyclerviewdemo3touch;

/**
 * Created by artur.musayelyan on 06/11/2017.
 */

public class SingleRow {
    private String title;
    private int imageID;

    public SingleRow() {

    }

    public SingleRow(String title, int imageID) {
        this.title = title;
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
