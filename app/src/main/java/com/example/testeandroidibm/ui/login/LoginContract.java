package com.example.testeandroidibm.ui.login;

import com.example.testeandroidibm.data.model.LoginRequest;
import com.example.testeandroidibm.data.model.LoginResponse;

public interface LoginContract {

    interface LoginView{

        void showError();

        void navigateToList(LoginResponse loginResponse);

        void errorUsername(String message);

        void enabledButton(boolean b);

        void errorPassword(String s);

    }

    interface LoginPresenter{

        void login(LoginRequest loginRequest);

        void validUserData(String userName);

        boolean validPasswordData(String password);
    }
}
