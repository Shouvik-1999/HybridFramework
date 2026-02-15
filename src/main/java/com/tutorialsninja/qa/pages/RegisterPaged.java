package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v142.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPaged {
    WebDriver driver;
    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@name='telephone']")
    private WebElement telephoneField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@name='confirm']")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//input[@name='newsletter' and @value=0]")
    private WebElement newsletterSubscribeNoOption;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacyPolicyCheckbox;
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    public RegisterPaged(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Actions
    public void enterFirstName(String firstName){
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }
    public void enterEmail(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void enterTelephone(String telephone){
        telephoneField.clear();
        telephoneField.sendKeys(telephone);
    }
    public void enterPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void enterConfirmPassword(String confirmPassword){
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(confirmPassword);
    }
    public void selectNewsletterSubscribeNoOption(){
        newsletterSubscribeNoOption.click();
    }
    public void selectPrivacyPolicyCheckBox(){
        privacyPolicyCheckbox.click();
    }
    public void clickOnContinueButton(){
        continueButton.click();
    }
    public String retrieveRegisterSuccessMessage(){
        return driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
    }
    public String retrieveDuplicateEmailWarningMessage(){
        return driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]")).getText();
    }


}
