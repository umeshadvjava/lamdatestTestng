package com.testcases;

import com.pages.ModalWindowPage;
import com.utilities.Retry;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static com.utilities.CreateDriver.*;

public class ModelWindowTest extends BaseTest{

    @Test
    public void windowHandle() throws InterruptedException {
        System.out.println("==== windowHandle Test ===");
    //    Thread.sleep(2000);
        getDriver().navigate().to("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
        ModalWindowPage modalWindowPage = new ModalWindowPage(getDriver());
        System.out.println("Window handle is :"+ modalWindowPage.getMainWindowHandle());
   //     Thread.sleep(2000);
    }
    @Test(retryAnalyzer = Retry.class)
    public void getWindowTitle() throws InterruptedException{
        System.out.println("==== getWindowTitle ===");
        ModalWindowPage modalWindowPage = new ModalWindowPage(getDriver());
        getDriver().navigate().to("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
        modalWindowPage.openTwitter();
        System.out.println("Parent window title : "+getDriver().getTitle());
        Set<String> allWindows = getDriver().getWindowHandles();
        List<String>  ls = new ArrayList<>(allWindows);
        getDriver().switchTo().window(ls.get(1));
        System.out.println("Child window title :  " +getDriver().getTitle());
        getDriver().close();
        getDriver().switchTo().window(ls.get(0));
        modalWindowPage.openFollowAll();
        System.out.println("==========");
        List<String> newWindows = new ArrayList<>(getDriver().getWindowHandles());
        newWindows.stream().map(s-> {
            getDriver().switchTo().window(s);
            return getDriver().getTitle();
        }).forEach(s-> System.out.println(" Window title is : "+s ));
   //     Thread.sleep(4000);
    }
}
