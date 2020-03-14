package com.example.testeandroidibm.ui.account;

import com.example.testeandroidibm.data.model.Statement;

import java.util.List;

public class AccountContract {

    interface ListStatementView{

        void showList(List<Statement> statements);

        void showError();

    }

    interface ListStatementPresenter{

        void getStatement(int id);
    }
}
