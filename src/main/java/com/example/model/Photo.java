package com.example.model;

/**
 * Created by benny on 23.11.15.
 */
public class Photo {

    private int idPhoto;
    private int username;
    private byte[] imageData;
    private String imageDescription;

    public Photo(int username, byte[] imageData, String imageDescription) {
        this.username = username;
        this.imageData = imageData;
        this.imageDescription = imageDescription;
    }

    public Photo(int idPhoto, int username, byte[] imageData, String imageDescription) {
        this.idPhoto = idPhoto;
        this.username = username;
        this.imageData = imageData;
        this.imageDescription = imageDescription;
    }

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }
}
