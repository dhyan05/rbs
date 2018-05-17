package com.test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void beforeStartup(){

        System.setProperty("webdriver.gecko.driver", "/Users/sanjanajain/rbs/src/drivers/node_modules/geckodriver/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php");

    }

    @After
    public void afterScenario(){
    driver.quit();
    }
}
