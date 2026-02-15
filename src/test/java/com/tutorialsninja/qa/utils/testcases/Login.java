package com.tutorialsninja.qa.utils.testcases;

import com.tutorialsninja.qa.common.WebSetup;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Login extends WebSetup {


    public Login() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initializeBrowserAndOpenApplication(prop.getProperty("browser"));

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test(priority = 1)
    public void verifyLoginWithValidCredentials() {
        HomePage hp=new HomePage(driver);
        LoginPage lp=new LoginPage(driver);
        hp.clickOnMyAccountButton();
        hp.clickOnLoginButton();
        lp.enterEmail(prop.getProperty("validEmail"));
        lp.enterPassword(prop.getProperty("validPassword"));
        lp.clickOnLoginButton();
        String actualLoginSuccessMessage = lp.retrieveLoginSuccessMessage();
        String expectedLoginSuccessMessage = dataProp.getProperty("LoginSuccessMessage");
        Assert.assertTrue(actualLoginSuccessMessage.contains(expectedLoginSuccessMessage));


    }
    @Test(priority = 3, dataProvider = "supplyData",enabled = false)
    public void verifyLoginWithValidCredentialsFromExcel(String email, String password) {
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @DataProvider
    public Object[][] supplyData() {
       return Utilities.getTestDataFormExcel();
    }

    @Test(priority = 2)
    public void verifyLoginWithInvalidCredentials() {
            HomePage hp=new HomePage(driver);
            LoginPage lp=new LoginPage(driver);
            hp.clickOnMyAccountButton();
            hp.clickOnLoginButton();
            lp.enterEmail(Utilities.GenerateEmailWithTimeStamp());
            lp.enterPassword(prop.getProperty("validPassword"));
            lp.clickOnLoginButton();
            Assert.assertTrue(lp.VerifyErrorLoginMessage());
    }


}