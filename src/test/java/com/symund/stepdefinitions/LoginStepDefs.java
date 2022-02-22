package com.symund.stepdefinitions;

import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();


    @Given("the user logged in {string} and {string}")
    public void the_user_logged_in_and(String usr, String psw) {
        loginPage.login(usr, psw);

    }

    @Then("Verify that user can login")
    public void verify_that_user_can_login() {
        Assert.assertTrue(Driver.get().getTitle().contains("Dashboard"));
    }


    @Then("the user should see the wrng message {string}")
    public void the_user_should_see_the_wrng_message(String wrngMessage) {
        Assert.assertEquals(loginPage.wrongUserOrPaswd.getText(), wrngMessage);
        BrowserUtils.waitFor(2);

    }

    @Then("the user should see the fillOut messageUser {string}")
    public void the_user_should_see_the_fillOut_messageUser(String msgUser) {
        Assert.assertEquals(msgUser, loginPage.userName.getAttribute("validationMessage"));
    }

    @Given("the user clears the password input box")
    public void the_user_clears_the_password_input_box() {
        loginPage.password.clear();
        BrowserUtils.waitFor(2);
    }

    @Then("the user should see the fillOut messagePassword {string}")
    public void the_user_should_see_the_fillOut_messagePassword(String msgPasswd) {
        Assert.assertEquals(msgPasswd, loginPage.password.getAttribute("validationMessage"));
    }


    @Given("the user enters username and password")
    public void the_user_enters_username_and_password() {
        loginPage.enterCredentialsOnly("Employee41", "Employee123");
    }


    @Given("the user see the password in a form of dots by default")
    public void the_user_see_the_password_in_a_form_of_dots_by_default() {
        Assert.assertEquals(loginPage.password.getAttribute("type"), "password");

    }

    @Given("the user clicks on eye button")
    public void the_user_clicks_on_eye_button() {
        loginPage.eyeBtn.click();
    }

    @Then("the user see password explicitly")
    public void the_user_see_password_explicitly() {
        Assert.assertEquals(loginPage.password.getAttribute("type"), "text");
    }

    @Given("the user can see Forgot password link")
    public void the_user_can_see_Forgot_password_link() {
        Assert.assertTrue(loginPage.forgotPasswLink.isDisplayed());
    }

    @Given("the user can click forgot password button")
    public void the_user_can_click_forgot_password_button() {
        loginPage.forgotPasswLink.click();
    }

    @Then("the user can see reset password button")
    public void the_user_can_see_reset_password_button() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(loginPage.resetButton.isDisplayed());
    }

    @Given("the user can see valid Username field")
    public void the_user_can_see_valid_Username_field() {
        Assert.assertTrue(loginPage.userName.isDisplayed());
    }

    @Given("the user can see valid Password field")
    public void the_user_can_see_valid_Password_field() {
        Assert.assertTrue(loginPage.password.isDisplayed());
    }


}







