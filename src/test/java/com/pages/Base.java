package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class Base {
    WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    protected void select(WebElement ele, String value) {
        Select select = new Select(ele);
        select.selectByValue(value);
    }

    protected void selectMultiSelect(By ele, List<String> value) {
        Select select = new Select(findElement(ele));
        value.stream().forEach(s -> select.selectByValue(s));
    }

    protected WebElement findElement(By by) {
        WebElement element = null;
        for (int i = 0; i < 2; i++) {
            try {
                element = driver.findElement(by);
            } catch (Exception e) {
                if (i == 1)
                    throw e;
            }
        }
        return element;
    }
    public List<String> getAllSelectedOptionFromDropDown(By by){
        Select select = new Select(findElement(by));
        List<WebElement> ls = select.getAllSelectedOptions();
        List<String> stringList= ls.stream().map(s-> s.getText()).collect(Collectors.toList());
        return stringList;
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
}
