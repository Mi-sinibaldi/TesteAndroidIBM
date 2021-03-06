package com.example.testeandroidibm.data.contract;

import com.example.testeandroidibm.data.model.StatementResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IStatementEndpoint {
    @GET("statements/{Id}")
    Call<StatementResponse> getStatement(@Path("Id") int Id);
}