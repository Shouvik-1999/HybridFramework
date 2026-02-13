package com.tutorialsninja.qa.utils.testcases;

import com.tutorialsninja.qa.common.WebSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchPage extends WebSetup {
    WebDriver driver;
        public SearchPage() {
            super();
        }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplication("edge");
    }
    @Test
    public void verifySearchWithValidProduct() {
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("MacBook");
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
        String actualProductName = driver.findElement(By.linkText("MacBook")).getText();
        String expectedProductName = "MacBook";
        Assert.assertTrue(actualProductName.contains(expectedProductName));
    }
    @Test
    public void verifySearchWithInvalidProduct() {
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("Maccbok");
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
        String actualNoProductMessage = driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).getText();
        String expectedNoProductMessage = "There is no product that matches the search criteria.";
        Assert.assertTrue(actualNoProductMessage.contains(expectedNoProductMessage));
    }


}
