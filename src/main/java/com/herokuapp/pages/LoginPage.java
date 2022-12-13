package com.herokuapp.pages;

import com.herokuapp.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends Utility {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(id = "username")
    WebElement usernameField;


    // By usernameField = By.id("username");
    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;
    //By passwordField = By.id("password");

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    //By loginButton = By.xpath("//button[@type='submit']");

    @CacheLookup
    @FindBy(xpath = "//div[@class='example']//h2")
    WebElement secureText;
    //By secureText = By.xpath("//div[@class='example']//h2");

    @CacheLookup
    @FindBy(xpath = "//div[@id='flash']")
    WebElement userErrorMessage;
    //By userErrorMessage = By.xpath("//div[@id='flash']");
    @CacheLookup
    @FindBy(xpath = "//div[@id='flash'])[1]")
    WebElement passwordErrorMessage;
    // By passwordErrorMessage = By.xpath("(//div[@id='flash'])[1]");


    public void enterUserName(String username) {
        Reporter.log("Enter username " + username + " to username field " + usernameField.toString());
        sendTextToElement(usernameField, username);

    }

    public void enterPassword(String password) {
        Reporter.log("Enter password " + password + " to password field " + passwordField.toString());
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        Reporter.log("Clicking on Login Button " + loginButton.toString());
        clickOnElement(loginButton);

    }

    public String getsecureText() {
        Reporter.log("Get secure text " + secureText.toString());
        return getTextFromElement(secureText);
    }


    public String getUsernameErrorMessage() {
        Reporter.log("Get error Message"+userErrorMessage.toString());
        return getTextFromElement(userErrorMessage);


    }

    public String getPasswordErrorMessage() {
        Reporter.log("Get password error Message"+passwordErrorMessage.toString());
        return getTextFromElement(passwordErrorMessage);
    }

}