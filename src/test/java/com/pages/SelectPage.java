package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SelectPage extends Base {

    By Select_a_day = By.id("select-demo");
    By SelectMulti = By.xpath("//*[@name=\"States\"]");
    public SelectPage(WebDriver driver){
        super(driver);
    }

    public void selectADay(String value){
        select(findElement(Select_a_day),value);
    }
    public String getSelectedValueFromDropDown(){
        return null;
    }
    public void multiSelectOption(List<String> list){
        selectMultiSelect(SelectMulti,list);
    }

    public List<String> getAllSelectedOption(){
        return getAllSelectedOptionFromDropDown(SelectMulti);
    }
}
