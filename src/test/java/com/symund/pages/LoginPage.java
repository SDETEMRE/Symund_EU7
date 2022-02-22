package com.symund.pages;

import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submit-form")
    public WebElement submit;

    @FindBy(css = ".warning.wrongPasswordMsg")
    public WebElement wrongUserOrPaswd;

    @FindBy(css = ".toggle-password")
    public WebElement eyeBtn;

    @FindBy(xpath = "//a[@id='lost-password']")
    public WebElement forgotPasswLink;

    @FindBy(id = "reset-password-submit")
    public WebElement resetButton;


    public void login(String usernameStr, String passwordStr) {
        userName.sendKeys(usernameStr);
        password.sendKeys(passwordStr);
        submit.click();

    }
    public void enterCredentialsOnly(String user, String Passw){
        userName.sendKeys(user);
        password.sendKeys(Passw);
    }

}

