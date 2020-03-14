package com.example.testeandroidibm.ui.account;

import com.example.testeandroidibm.data.contract.IStatementEndpoint;
import com.example.testeandroidibm.data.model.StatementResponse;
import com.example.testeandroidibm.data.remote.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountPresenter implements AccountContract.ListStatementPresenter {

    private AccountContract.ListStatementView view;

    public AccountPresenter(AccountContract.ListStatementView view) {
        this.view = view;
    }

    @Override
    public void getStatement(int Id) {
        IStatementEndpoint statementService = ServiceGenerator.createService(IStatementEndpoint.class);
        Call<StatementResponse> call = statementService.getStatement(Id);

        call.enqueue(new Callback<StatementResponse>() {
            @Override
            public void onResponse(Call<StatementResponse> call, Response<StatementResponse> response) {
                if (response.isSuccessful()) {
                    StatementResponse statementResponse = response.body();
                    view.showList(statementResponse.getStatementList());
                }
            }

            @Override
            public void onFailure(Call<StatementResponse> call, Throwable t) {
                view.showError();
            }
        });

    }
}