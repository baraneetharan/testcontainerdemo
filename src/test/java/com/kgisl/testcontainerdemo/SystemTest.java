package com.kgisl.testcontainerdemo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.*;
import org.testcontainers.containers.wait.strategy.Wait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// import org.testcontainers.utility.MountableFile;​
import java.io.File;
// import java.util.stream.Stream;​

public class SystemTest {
    private static Network net = Network.newNetwork();
    @Rule
    public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withDesiredCapabilities(DesiredCapabilities.chrome());

    @Test
    public void whenNavigatedToPage_thenHeadingIsInThePage() {
        RemoteWebDriver driver = chrome.getWebDriver();
        driver.get("https://saucelabs.com/test/guinea-pig");
        String heading = driver.findElement(By.xpath("/html/body/h1")).getText();
        System.out.println("*************************************************");
        System.out.println("*************************************************");
        System.out.println("Selenium Test Container test runs");
        System.out.println("*************************************************");
        System.out.println("*************************************************");
        assertEquals("This page is a Selenium sandbox", heading);
    }
}
