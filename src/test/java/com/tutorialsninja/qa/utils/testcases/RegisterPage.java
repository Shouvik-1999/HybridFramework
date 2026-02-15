package com.tutorialsninja.qa.utils.testcases;

import com.tutorialsninja.qa.common.WebSetup;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPaged;
import com.tutorialsninja.qa.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegisterPage extends WebSetup {

    public RegisterPage() {
        super();
    }

    @AfterMethod
    public void tearDown() {
        driver = new ChromeDriver();
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void setUp() {
        initializeBrowserAndOpenApplication("chrome");
    }

    @Test(priority = 1)
    public void verifyRegisterWithValidCredentials() {
        RegisterPaged rp=new RegisterPaged(driver);
        HomePage hp=new HomePage(driver);
        hp.clickOnMyAccountButton();
        hp.clickOnRegisterButton();
        rp.enterFirstName("Souvik");
        rp.enterLastName("Kar");
        rp.enterEmail(Utilities.GenerateEmailWithTimeStamp());
        rp.enterTelephone("9876543210");
        rp.enterPassword("Skar@112");
        rp.enterConfirmPassword("Skar@112");
        rp.selectNewsletterSubscribeNoOption();
        rp.selectPrivacyPolicyCheckBox();
        rp.clickOnContinueButton();
        String actualSuccessMessage = rp.retrieveRegisterSuccessMessage();
        String expectedSuccessMessage = dataProp.getProperty("expectedRegisterSuccessMessage");
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
        driver.quit();
    }

    @Test(priority = 2)
    public void verifyRegisterWithExistingEmail() {
        RegisterPaged rp=new RegisterPaged(driver);
        HomePage hp=new HomePage(driver);
        hp.clickOnMyAccountButton();
        hp.clickOnRegisterButton();
        rp.enterFirstName("Souvik");
        rp.enterLastName("Kar");
        rp.enterEmail(prop.getProperty("validEmail"));
        rp.enterTelephone("9876543210");
        rp.enterPassword("Skar@112");
        rp.enterConfirmPassword("Skar@112");
        rp.selectNewsletterSubscribeNoOption();
        rp.selectPrivacyPolicyCheckBox();
        rp.clickOnContinueButton();
        String actualWarningMessage = rp.retrieveDuplicateEmailWarningMessage();
        String expectedWarningMessage = dataProp.getProperty("expectedDuplicateEmailWarningMessage");
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
        driver.quit();
    }
}

