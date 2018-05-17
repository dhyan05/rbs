package com.test.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class homepage {
    public homepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickTshirtButton(){
        TShirt_Button.click();

    }



    //WebElements
    @FindBy (css = "#block_top_menu > ul > li:nth-child(3) > a") public WebElement TShirt_Button;

}
