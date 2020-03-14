package com.example.testeandroidibm;

import com.example.testeandroidibm.ui.login.LoginContract;
import com.example.testeandroidibm.ui.login.LoginPresenter;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestEmail extends TestCase {

    @Mock
    private LoginContract.LoginView view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testEmailTrue() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("michelle_araujo92@hotmail.com");
        Assert.assertEquals(true, b);
    }

    @Test
    public void testEmailWithoutSpecialCharacters() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("michellearaujo92hotmailcom");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailWithoutDotBr() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("michellearaujo92hotmail.com");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailOnlyUpperCase() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("MICHELLE.ARAUJOGMAILCOMBR");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailOnlyLowerCase() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("michellearaujogmailcombr");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailWithSpace() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("michelle.araujo92@hotmail. com");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailWithoutDomain() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("michelle.araujo@");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailOnlyNumbers() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("212345");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailWithoutDotCom() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("michelle.araujo@gmail");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailUpperCase() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("MICHELLE.ARAUJO@GMAIL.COM");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailOnlySpecialCharacters() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("@1--.!@@");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailIsEmpty() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData(" ");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailTowSpecialCharacters() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("michelle.araujo@@gmail.com");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailOnlyOneUpperCase() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("michelle.araujo@Gmail.com");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailWithNunbers() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPasswordData("michelle.araujo56@gmail.com");
        Assert.assertEquals(true, b);
    }
}
