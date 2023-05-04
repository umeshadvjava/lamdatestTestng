package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CreateDriver {
    private static ThreadLocal<WebDriver> threadLocaldriver = new ThreadLocal<>();

    public static void initializeDriver() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("./src/test/resources/config.properties")));
            switch (properties.getProperty("browser")){
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    threadLocaldriver.set(new ChromeDriver(chromeOptions));
                    break;
                default:
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        getDriver().manage().window().maximize();
        getDriver().get(properties.getProperty("lurl"));

    }

    public static WebDriver getDriver(){
        System.out.println("Thread id : "+Thread.currentThread().getName());
        return threadLocaldriver.get();
    }
    public static void unloadDriver(){
        getDriver().quit();
        threadLocaldriver.remove();
    }
}
