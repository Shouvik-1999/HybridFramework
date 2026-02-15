package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//h2[text()='My Account']")
    private WebElement loginSuccessMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement loginFailureMessage;






    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    //Actions
    public void enterEmail(String email){

        emailField.clear();
        emailField.sendKeys(email);
    }
    public void enterPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickOnLoginButton(){
        loginButton.click();
    }
    public String retrieveLoginSuccessMessage(){
        return loginSuccessMessage.getText();
    }
    public boolean VerifyErrorLoginMessage(){
        return loginFailureMessage.isDisplayed();
    }


}
