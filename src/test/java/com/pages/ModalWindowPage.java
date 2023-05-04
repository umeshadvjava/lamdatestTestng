package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class ModalWindowPage extends Base{

    By twitter  = By.xpath("//a[@title=\"Follow @Lambdatesting on Twitter\"]");
    By followAll = By.id("followall");
    public ModalWindowPage(WebDriver driver){
        super(driver);
    }

    public String getMainWindowHandle(){
        return driver.getWindowHandle();
    }

    public ModalWindowPage openTwitter(){
        findElement(twitter).click();
        return this;
    }
    public void openFollowAll(){
        findElement(followAll).click();
    }


}
