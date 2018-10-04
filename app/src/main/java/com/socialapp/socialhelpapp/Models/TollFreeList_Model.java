package com.socialapp.socialhelpapp.Models;

public class TollFreeList_Model {
    private String tollfreetextname;
    private String tollfreenumber;

    public TollFreeList_Model() {
    }

    public TollFreeList_Model(String tollfreetextname, String tollfreenumber) {
        this.tollfreetextname = tollfreetextname;
        this.tollfreenumber = tollfreenumber;
    }

    public String getTollfreetextname() {
        return tollfreetextname;
    }

    public void setTollfreetextname(String tollfreetextname) {
        this.tollfreetextname = tollfreetextname;
    }

    public String getTollfreenumber() {
        return tollfreenumber;
    }

    public void setTollfreenumber(String tollfreenumber) {
        this.tollfreenumber = tollfreenumber;
    }
}
