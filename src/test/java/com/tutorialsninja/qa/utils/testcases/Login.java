package com.tutorialsninja.qa.utils.testcases;

import com.tutorialsninja.qa.common.WebSetup;
import com.tutorialsninja.qa.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Login extends WebSetup {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
         driver = initializeBrowserAndOpenApplication("chrome");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test(priority = 1)
    public void verifyLoginwithValidCredentials() {

        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("krshouvik@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Skar@1999");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
        driver.quit();

    }

    @Test(priority = 2)
    public void verifyLoginWithInvalidCredentials() {


        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Utilities.GenerateEmailWithTimeStamp());
        driver.findElement(By.xpath("//input[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Skar@1999");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
        driver.quit();
    }


}