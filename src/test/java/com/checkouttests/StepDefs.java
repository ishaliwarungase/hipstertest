package com.checkouttests;

import java.util.concurrent.TimeUnit;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs 
{
    WebDriver driver;
    @Before public void setUp()
    { 
        System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/jobs/hipstertest/workspace/src/test/java/com/checkouttests/chromedriver");
        ChromeOptions options = new ChromeOptions().setHeadless(true);

        driver = new ChromeDriver(options);

        driver.get("http://mobilecom.coe.com/");

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    } 

    @Given("User browse products")
    public void user_browse_products()
    {
        driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div[2]/div/a")).click(); 

        driver.findElement(By.xpath("/html/body/main/div[1]/div/div[2]/div/form/div/button")).click();

    }

    @When("User enters information to place order")
    public void user_enters_information_to_place_order() 
    {
        driver.findElement(By.id("email")).sendKeys("");

        driver.findElement(By.id("street_address")).sendKeys("");

        driver.findElement(By.id("zip_code")).sendKeys("");
                         
        driver.findElement(By.id("city")).sendKeys("");
           
        driver.findElement(By.id("state")).sendKeys("");

        driver.findElement(By.id("country")).sendKeys("");

        driver.findElement(By.id("credit_card_number")).sendKeys("");
          
        Select credit_card_expiration_month = new Select(driver.findElement(By.id("credit_card_expiration_month")));
        credit_card_expiration_month.selectByVisibleText("");

        Select credit_card_expiration_year = new Select(driver.findElement(By.id("credit_card_expiration_year")));
        credit_card_expiration_year.selectByVisibleText("");
           
        driver.findElement(By.id("credit_card_cvv")).sendKeys("");
    }

    @Then("Order is Placed")
    public void order_is_placed() 
    {
        driver.findElement(By.xpath("/html/body/main/div/div/div[4]/div/form/div[4]/button")).click();
        try 
          {
                String errmsg = "Unable to complete registration, please try again later";

                String msg = driver.findElement(By.id("email")).getAttribute("value");

                if(msg.isEmpty())
                {
                    Assert.fail("Error");
                }
          }
        catch (Exception e) 
         {

         }
        driver.close();
    }
        
}
      


