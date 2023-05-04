package com.testcases;

import com.pages.SelectPage;
import com.sun.javafx.binding.Logging;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import com.utilities.Logconfig;
import static com.utilities.CreateDriver.*;

import static com.utilities.Logconfig.*;

public class SelectTest extends BaseTest{


    @Test
    public void selectDropdown() throws InterruptedException {
        Log.info(" Method started");
        System.out.println("==== selectDropdown ==="+ Thread.currentThread().getName());
        SelectPage selectPage = new SelectPage(getDriver());
        selectPage.selectADay("Monday");
        Thread.sleep(1000);
        System.out.println("==== selectDropdown end ==="+ Thread.currentThread().getName());
        Assert.assertTrue(false);
    }

    @Test
    public void multiSelect(){
        System.out.println("==== multiSelect ==="+ Thread.currentThread().getName());
        List<String> ls = new ArrayList<>();
        ls.add("New York");
        ls.add("Texas");
        ls.add("Washington");
        SelectPage selectPage = new SelectPage(getDriver());
        selectPage.multiSelectOption(ls);
        System.out.println("Printing all the options selected..");
        List<String> options = selectPage.getAllSelectedOption();
        selectPage.getAllSelectedOption().forEach(s-> System.out.println(s));
       // Assert.assertEquals(ls,options);
        Assert.assertTrue(ls.containsAll(options));
        System.out.println("==== multiSelect end ==="+Thread.currentThread().getName());
        Assert.assertTrue(false);
    }
}
