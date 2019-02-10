package com.socialapp.socialhelpapp.Models;

import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

public class ServiceList_Model {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String servicename;
    @SerializedName("type")
    private String type;
    @SerializedName("subType")
    private String subType;
    @SerializedName("image")
    private String imageurl;

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getImageUrl() {
        return imageurl;
    }

    public void setImageUrl(String imageurl) {
        this.imageurl = imageurl;
    }
}
