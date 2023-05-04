package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Frames extends Base{

    By firstNamePath = By.xpath("//*[@name=\"fname\"]");
    By lastNamePath = By.xpath("//*[@name=\"lname\"]");
    By emailPath = By.xpath("//input[@name=\"email\"]");
    By loginButton = By.xpath("//a[text()=\"Log in\"]");
    By emailLogin = By.xpath("//input[@name=\"email\"]");
    By passwordPath = By.xpath("//input[@name=\"password\"]");

    public Frames(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String password){
        findElement(loginButton).click();
        findElement(emailLogin).sendKeys(userName);
        findElement(passwordPath).sendKeys(password);
        try { Thread.sleep(2000);} catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void setName(String firstName, String lastName){
        driver.switchTo().frame(findElement(By.id("firstFr")));
        findElement(firstNamePath).sendKeys(firstName);
        findElement(lastNamePath).sendKeys(lastName);
        try { Thread.sleep(2000);} catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void enterEmail(String email){
        driver.switchTo().frame(findElement(By.xpath("//iframe[@src=\"innerFrame\"]")));
        findElement(emailPath).sendKeys(email);
        driver.switchTo().defaultContent();
        try { Thread.sleep(2000);} catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

