package com.tutorialsninja.qa.utils.testcases;

import com.tutorialsninja.qa.common.WebSetup;
import com.tutorialsninja.qa.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegisterPage extends WebSetup {
    WebDriver driver;
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
        driver = initializeBrowserAndOpenApplication("chrome");
    }

    @Test(priority = 1)
    public void verifyRegisterWithValidCredentials() {
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).clear();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Souvik");
        driver.findElement(By.xpath("//input[@name='lastname']")).clear();
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kar");
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Utilities.GenerateEmailWithTimeStamp());
        driver.findElement(By.xpath("//input[@name='telephone']")).clear();
        driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("9876543210");
        driver.findElement(By.xpath("//input[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Skar@112");
        driver.findElement(By.xpath("//input[@name='confirm']")).clear();
        driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("Skar@112");
        driver.findElement(By.xpath("//input[@name='newsletter' and @value=0]")).click();
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        String actualSuccessMessage = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
        String expectedSuccessMessage = "Your Account Has Been Created!";
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
        driver.quit();
    }

    @Test(priority = 2)
    public void verifyRegisterWithExistingEmail() {
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).clear();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Souvik");
        driver.findElement(By.xpath("//input[@name='lastname']")).clear();
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kar");
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(prop.getProperty("validEmail"));
        driver.findElement(By.xpath("//input[@name='telephone']")).clear();
        driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("9876543210");
        driver.findElement(By.xpath("//input[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Skar@112");
        driver.findElement(By.xpath("//input[@name='confirm']")).clear();
        driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("Skar@112");
        driver.findElement(By.xpath("//input[@name='newsletter' and @value=0]")).click();
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]")).getText();
        String expectedWarningMessage = "Warning: E-Mail Address is already registered!";
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
        driver.quit();
    }
}

