package com.example.sound.laba1;

public class StackItem {

    private String itemText;

    // "image1","image2",..
    private String imageName;

    private String info;

    public StackItem(String text, String imageName, String info) {
        this.imageName = imageName;
        this.itemText = text;
        this.info = info;
    }

    public String getImageName() {
        return imageName;
    }


    public String getItemText() {
        return itemText;
    }

    public String getItemInfo(){
        return info;
    }
}
