package com.socialapp.socialhelpapp.Models;

import com.google.gson.annotations.SerializedName;

public class ProductList_Model {
    @SerializedName("id")
    private String productid;
    @SerializedName("name")
    private String productname;
    @SerializedName("value")
    private String productprice;
    @SerializedName("image")
    private String productimage;

    public ProductList_Model() {
    }

    public ProductList_Model(String productid, String productname, String productimage, String productprice) {
        this.productid = productid;
        this.productname = productname;
        this.productimage = productimage;
        this.productprice = productprice;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }
}
