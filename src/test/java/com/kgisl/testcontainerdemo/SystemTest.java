package com.kgisl.testcontainerdemo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.*;
import org.testcontainers.containers.wait.strategy.Wait;
// import org.testcontainers.utility.MountableFile;​
import java.io.File;
// import java.util.stream.Stream;​

public class SystemTest {
    private static Network net = Network.newNetwork();
    @ClassRule
    public static BrowserWebDriverContainer browser = (BrowserWebDriverContainer) new BrowserWebDriverContainer()
            .withDesiredCapabilities(DesiredCapabilities.chrome())
            .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL, new File("build"))
            .withNetwork(net);

    @Test
    public void seleniumTest() {
        RemoteWebDriver webDriver = browser.getWebDriver();
        webDriver.get("https://www.google.com/");
        WebElement content = webDriver.findElementById("q");
        assert content.getText().equals("Foobar");
    }
}