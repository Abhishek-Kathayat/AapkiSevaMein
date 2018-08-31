package com.socialapp.socialhelpapp.Models;

public class ServiceList_Model {
    private String servicename;

    public ServiceList_Model() {
    }

    public ServiceList_Model(String servicename) {
        this.servicename = servicename;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }
}
