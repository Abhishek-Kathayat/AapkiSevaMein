package com.socialapp.socialhelpapp.rest;

import com.socialapp.socialhelpapp.Models.ProductList_Model;
import com.socialapp.socialhelpapp.Models.ServiceList_Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("category/list")
    Call<List<ServiceList_Model>> getServices();

    @GET("item/list")
    Call<List<ProductList_Model>> getProducts();
}
