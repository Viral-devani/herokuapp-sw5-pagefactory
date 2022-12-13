package com.herokuapp.testsuite;

import com.herokuapp.customlisteners.CustomListeners;
import com.herokuapp.pages.LoginPage;
import com.herokuapp.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;
@BeforeMethod(alwaysRun = true)
public void inIt(){
    loginPage =new LoginPage();
}

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateWithValidCredentials() {
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        loginPage.getsecureText();
        String expectedMessage = "Secure Area";
        String actualMessage = loginPage.getsecureText();
        Assert.assertEquals(actualMessage, expectedMessage, "Text is not displyed");

    }

    @Test(groups = {"smoke","regresssion"})
    public void verifyTheUsernameErrorMessage() {
        loginPage.enterUserName("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        loginPage.getsecureText();

        String expectedMessage = "Your username is invalid!\n" + "×";
        String actualMessage = loginPage.getUsernameErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect text");

    }

    @Test(groups = "regression")
    public void verifyPasswordErrorMessage() {
        SoftAssert softAssert=new SoftAssert();
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword1");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Your password is invalid!" +
                "×";
        String actualMessage = loginPage.getPasswordErrorMessage();
        softAssert.assertEquals(actualMessage, expectedMessage, "Message is not displyed");
        //Assert.assertEquals(actualMessage, expectedMessage, "Message is not displyed");


    }
}
