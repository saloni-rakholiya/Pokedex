package com.example.alien.models;

import com.google.gson.annotations.SerializedName;

public class Pokemon {

    private int number;
    private String name;
    private String url;
    @SerializedName("height")
    private  String height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getHeight(){return  height;}

    public void setHeight(String height){this.height= height;}


    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        String[] urlp=url.split("/");
        return Integer.parseInt(urlp[urlp.length -1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
