package com.tutorialsninja.qa.utils.testcases;

import com.tutorialsninja.qa.common.WebSetup;
import com.tutorialsninja.qa.pages.SearchPaged;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchPage extends WebSetup {

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
        initializeBrowserAndOpenApplication("edge");
    }
    @Test
    public void verifySearchWithValidProduct() {
            SearchPaged sp= new SearchPaged(driver);
        sp.enterProductNameInSearchBox(dataProp.getProperty("validProductName"));
        sp.clickOnSearchButton();
        String actualProductName = sp.getMacBookLinkText();
        String expectedProductName = dataProp.getProperty("expectedProductName");
        Assert.assertTrue(actualProductName.contains(expectedProductName));
    }
    @Test
    public void verifySearchWithInvalidProduct() {
        SearchPaged sp= new SearchPaged(driver);
        sp.enterProductNameInSearchBox(dataProp.getProperty("InvalidProductName"));
        sp.clickOnSearchButton();
        String actualNoProductMessage = sp.getNoProductMessageText();
        String expectedNoProductMessage = dataProp.getProperty("expectedNoProductMessage");
        Assert.assertTrue(actualNoProductMessage.contains(expectedNoProductMessage));
    }


}
