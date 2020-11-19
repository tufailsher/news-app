package com.example.newsapp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("cjob_title")
    @Expose
    private String cjobTitle;
    @SerializedName("clogo")
    @Expose
    private String clogo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCjobTitle() {
        return cjobTitle;
    }

    public void setCjobTitle(String cjobTitle) {
        this.cjobTitle = cjobTitle;
    }

    public String getClogo() {
        return clogo;
    }

    public void setClogo(String clogo) {
        this.clogo = clogo;
    }

}
