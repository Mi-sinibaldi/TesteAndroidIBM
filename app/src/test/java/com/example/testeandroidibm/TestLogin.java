package com.example.testeandroidibm;

import com.example.testeandroidibm.ui.login.LoginContract;
import com.example.testeandroidibm.ui.login.LoginPresenter;
import com.example.testeandroidibm.ui.login.MainActivity;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestLogin extends TestCase {

    @Mock
    private LoginContract.LoginView view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoginSucessTrue() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("A1@kl35");
        Assert.assertEquals(true, b);
    }


    @Test
    public void testLoginOnlyLetter() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("AheAe");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testLoginOnlySpecialCharacter() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("@!-@!@");
        Assert.assertEquals(false, b);
    }


    @Test
    public void testLoginIsEmpty() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean a = loginPresenter.validPasswordData(" ");
        Assert.assertEquals(false, a);
    }

    @Test
    public void testLoginOnlyUpperCase() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean a = loginPresenter.validPasswordData("EHIMI");
        Assert.assertEquals(false, a);
    }

    @Test
    public void testLoginOnlyLetterCase() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean a = loginPresenter.validPasswordData("ehiar");
        Assert.assertEquals(false, a);
    }

    @Test
    public void testLoginLowerCase() {
        LoginContract.LoginView view = new MainActivity();
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("ehi@2010");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testLoginUpperCase() {
        LoginContract.LoginView view = new MainActivity();
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("EHI@2010");
        Assert.assertEquals(true, b);
    }

    @Test
    public void testLoginNoSpecialCharacter() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("ehi2010");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testLoginOnlyNumbers() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("2010");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testLoginNoNumbers() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("Qhahan@");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testLoginEspace() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("Qhahan @");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testLoginNoLetters() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("123@123");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testLoginLessThan4Characters() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("12a");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testLoginTowSpecialCharacters() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("Ehi@@2010");
        Assert.assertEquals(true, b);
    }

}