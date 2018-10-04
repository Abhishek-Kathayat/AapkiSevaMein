package com.socialapp.socialhelpapp.Models;

public class CartList_Model {
    private String productname, productprice, productimage, productquantity;

    public CartList_Model() {
    }

    public CartList_Model(String productname, String productimage, String productprice, String productquantity) {
        this.productname = productname;
        this.productimage = productimage;
        this.productprice = productprice;
        this.productquantity = productquantity;
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

    public String getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(String productquantity) {
        this.productquantity = productquantity;
    }
}
