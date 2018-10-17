package com.socialapp.socialhelpapp.Models;

public class OrderList_Model {
    private String productname, productprice, productimage, productquantity, productpurchasedate;

    public OrderList_Model() {
    }

    public OrderList_Model(String productname, String productimage, String productprice, String productquantity, String productpurchasedate) {
        this.productname = productname;
        this.productimage = productimage;
        this.productprice = productprice;
        this.productquantity = productquantity;
        this.productpurchasedate = productpurchasedate;
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

    public String getProductpurchasedate() {
        return productpurchasedate;
    }

    public void setProductpurchasedate(String productpurchasedate) {
        this.productpurchasedate = productpurchasedate;
    }
}
