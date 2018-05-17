package com.test;

import com.test.PageObjects.homepage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class stepDefs{
    WebDriver driver = Hooks.driver;
    WebDriverWait wait = new WebDriverWait(driver,10);
    SoftAssert softAssert = new SoftAssert();

    @Given ("^User is in T-shirt catalog page$")
    public void loggedInUser() {
        homepage page = new homepage(driver);
        page.clickTshirtButton();
        driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a")).click();
    }

    @When("^user order a T-shirt$")
    public void orderTshirt() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#center_column > ul > li > div > div.left-block > div > a.product_img_link > img")));
        driver.findElement(By.cssSelector("#center_column > ul > li > div > div.left-block > div > a.product_img_link > img")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#add_to_cart > button > span")));
        //driver.findElement(By.id("add_to_cart")).click();
        driver.findElement(By.cssSelector("#add_to_cart > button > span")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span")));
        driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")));
        driver.findElement(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("someone@example.com");
        driver.findElement(By.cssSelector("#passwd")).sendKeys("Password123");
        driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
        driver.findElement(By.cssSelector("button.button:nth-child(4)")).click();
        driver.findElement(By.cssSelector("#cgv")).click();
        driver.findElement(By.cssSelector("button.button:nth-child(4)")).click();
        driver.findElement(By.cssSelector(".bankwire")).click();
        driver.findElement(By.cssSelector("button.button-medium")).click();
        String text = driver.findElement(By.cssSelector(".box")).getText();
        String verfication[] =text.split(" ");
        String orderNumber = verfication[36];
    }


    @Then("^user should have those details in order history$")
    public void orderhistory(){

        driver.findElement(By.cssSelector(".account > span:nth-child(1)")).click();
        driver.findElement(By.cssSelector("div.col-sm-6:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1) > span:nth-child(2)")).click();
        String OrderNumber = driver.findElement(By.cssSelector("tr.first_item > td:nth-child(1) > a:nth-child(2)")).getText();
        System.out.println("Order Number="+OrderNumber);
        //System.out.println(test);
        //softAssert.assertEquals(OrderNumber,orderTshirt());



    }

    @Given ("^User is logged in$")
    public void updateMyAccount() {
        homepage page = new homepage(driver);
        driver.findElement(By.cssSelector(".login")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("someone@example.com");
        driver.findElement(By.cssSelector("#passwd")).sendKeys("Password123");
        driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
    }

    @When("^user goes to personal details$")
    public void editMyAccount() {
        driver.findElement(By.cssSelector("div.col-sm-6:nth-child(1) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1) > span:nth-child(2)")).click();
    }

    @And("^user updates his first name$")
    public void updateFirstName(){
        driver.findElement(By.cssSelector("#firstname")).clear();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Dhyan");
        driver.findElement(By.cssSelector("#old_passwd")).sendKeys("Password123");
        driver.findElement(By.cssSelector("#center_column > div > form > fieldset > div:nth-child(11) > button > span")).click();


    }

    @Then("^first name should be updated$")
    public void UpdateMyAccount(){
        String alertMessage = driver.findElement(By.cssSelector(".alert")).getText();
        String expectedOutcome = "Your personal information has been successfully updated.";
        softAssert.assertEquals(expectedOutcome,alertMessage);
        softAssert.assertAll();

    //    driver.findElement(By.cssSelector("#firstname")).sendKeys("Test123");
    //    driver.findElement(By.cssSelector("#passwd")).sendKeys("Password123");
    //    driver.findElement(By.cssSelector("#center_column > div > form > fieldset > div:nth-child(11) > button > span")).click();



    }


}
