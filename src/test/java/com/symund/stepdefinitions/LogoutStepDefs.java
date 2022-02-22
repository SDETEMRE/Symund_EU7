package com.symund.stepdefinitions;

import com.symund.pages.LoginPage;
import com.symund.pages.LogoutPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LogoutStepDefs {

    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();

    @Given("the user logged in with username {string} and password {string}")
    public void theUserLoggedInWithUsernameAndPassword(String username, String password) {
        loginPage.login(username, password);
    }

    @Given("the user clicks on avatar button")
    public void theUserClicksOnAvatarButton() {
        logoutPage.avatar.click();
        BrowserUtils.waitFor(3);

    }

    @And("the user clicks on logout button")
    public void theUserClicksOnLogoutButton() {
        logoutPage.logoutButton.click();
    }

    @Then("the user logged out and returns the login page")
    public void theUserLoggedOutAndReturnsTheLoginPage() {
        BrowserUtils.waitFor(3);
        Assert.assertFalse(Driver.get().getTitle().contains("Dashboard"));
    }

    @Given("the user clicks back button after logout")
    public void theUserClicksBackButtonAfterLogout() {
        BrowserUtils.waitFor(3);
        Driver.get().navigate().back();

    }

    @Then("the user can not go to home page")
    public void theUserCanNotGoToHomePage() {
        BrowserUtils.waitFor(3);
        Assert.assertFalse(Driver.get().getTitle().contains("Dashboard"));
    }
}
