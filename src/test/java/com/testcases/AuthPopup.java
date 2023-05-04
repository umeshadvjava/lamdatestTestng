package com.testcases;

import org.testng.annotations.Test;

import static com.utilities.CreateDriver.getDriver;

public class AuthPopup extends BaseTest{

    @Test
    public void authPopup() throws InterruptedException {
        String name="admin", pass="admin";
        getDriver().get("http://"+name+":"+pass+"@"+"the-internet.herokuapp.com/basic_auth");

        Thread.sleep(3000);
    }
}
