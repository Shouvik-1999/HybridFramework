package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPaged {
    WebDriver driver;
    @FindBy(name="search")
    private WebElement searchBox;
    @FindBy(xpath="//button[@class='btn btn-default btn-lg']")
    private WebElement searchButton;
    @FindBy(linkText="MacBook")
    private WebElement macBookLink;
    @FindBy(xpath="//p[contains(text(),'There is no product')]")
    private WebElement noProductMessage;

    public SearchPaged(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //Actions
    public void enterProductNameInSearchBox(String productName){
       searchBox.clear();
         searchBox.sendKeys(productName);

    }
    public void clickOnSearchButton(){
        searchButton.click();
    }
    public String getMacBookLinkText(){
        return macBookLink.getText();
    }
    public String getNoProductMessageText(){
        return noProductMessage.getText();
    }

}
