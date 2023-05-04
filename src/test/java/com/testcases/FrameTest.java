package com.testcases;

import com.pages.Frames;
import com.utilities.CreateDriver;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest{


    @Test
    public void iFrameTest(){
        Frames frames = new Frames(CreateDriver.getDriver());
        frames.setName("Umesh","Nageshwar");
        frames.enterEmail("test@gmail.com");
        frames.login("test@gmail.com","test");

    }
}
