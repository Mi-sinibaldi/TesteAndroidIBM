package com.example.testeandroidibm.data.contract;

import com.example.testeandroidibm.data.model.LoginRequest;
import com.example.testeandroidibm.data.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ILoginEndpoint {
    @POST("login")
    Call<LoginResponse> postLogin(@Body LoginRequest loginRequest);

}
