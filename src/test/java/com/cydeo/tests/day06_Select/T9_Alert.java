package com.cydeo.tests.day06_Select;

import com.cydeo.tests.day03_cssSelector.WebDriverFacory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class T9_Alert {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        driver = WebDriverFacory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

    @Test
    public void information_alert_test1(){
        driver = WebDriverFacory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");

        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        informationAlertButton.click();

        Alert alert = driver.switchTo().alert();

        alert.accept();

        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue("Result text is NOT displayed!", resultText.isDisplayed());

        String expectedText = "You successfully clicked an alert";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText, expectedText, "Actual result text is NOT as expected!");
    }

    @Test
    public void confirmation_alert_test2(){

        WebElement confirmationAlert = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmationAlert.click();


        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultText.isDisplayed());
    }

}