package com.epam.lab.stepdefinitions;

import com.epam.lab.pageobject.LoginPage;
import com.epam.lab.utils.ConfigFileReader;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginStepDefinition  {
    ConfigFileReader configFileReader;
    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setupDriver() {
        configFileReader = new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(new ConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);
    }

    @Given("^User navigate to Gmail website$")
    public void navigateToGmail() {
        driver.get(configFileReader.getWebSiteUrl());
    }

    @When("^User enter Username as ([^\"]*)$")
    public void enterUsername(String userName) {
        loginPage = new LoginPage(driver);
        loginPage.enterUserName(userName);
    }

    @And("^User click submit button$")
    public void submitUserName() {
        loginPage.submitUserName();
    }

    @And("^User enter Password as ([^\"]*)$")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("^User click submit password button$")
    public void submitPassword() {
        loginPage.submitPassword();
    }

    @Then("^User should be on inbox page$")
    public void checkLoginStatus() {
        Assert.assertTrue(loginPage.checkLoginStatus());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}