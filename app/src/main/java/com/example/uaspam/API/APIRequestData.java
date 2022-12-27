package com.example.uaspam.API;

import com.example.uaspam.Model.DataModel;
import com.example.uaspam.Model.ResponseModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestData {
//    @GET("uasresto")
//    Call<ResponseModel> ardRetrieveData();

    @GET("uasresto")
    Call<ArrayList<DataModel>> ardRetrieveData();
}
