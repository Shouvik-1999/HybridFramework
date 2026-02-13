package com.tutorialsninja.qa.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class WebSetup {
    WebDriver driver;
    public Properties prop;

    public WebDriver initializeBrowserAndOpenApplication(String browserName) {

        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();

        } else
            driver = new FirefoxDriver();

        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;
    }

    public WebSetup() {
        try {
            FileInputStream fis = new FileInputStream(".\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
