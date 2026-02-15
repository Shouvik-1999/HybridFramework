package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    @FindBy(linkText = "My Account")
    private WebElement myAccountButton;

    @FindBy(linkText = "Login")
    private WebElement loginButtonOnPage;

    @FindBy(linkText = "Register")
    private WebElement registerButtonOnPage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Actions
    public void clickOnMyAccountButton() {
        myAccountButton.click();
    }

    public void clickOnLoginButton() {
        loginButtonOnPage.click();
    }

    public void clickOnRegisterButton() {
        registerButtonOnPage.click();
    }
}
