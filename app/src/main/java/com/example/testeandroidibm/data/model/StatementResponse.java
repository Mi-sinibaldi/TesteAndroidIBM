package com.example.testeandroidibm.data.model;

import java.util.List;

public class StatementResponse {

    private List<Statement> statementList;
    private java.lang.Error error;

    public List<Statement> getStatementList() {
        return statementList;
    }

    public void setStatementList(List<Statement> statementList) {
        this.statementList = statementList;
    }

    public java.lang.Error getError() {
        return error;
    }

    public void setError(java.lang.Error error) {
        this.error = error;
    }

}
