package com.kgisl.testcontainerdemo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;

/**
 *
 */
public class ChromeWebDriverContainerTest extends BaseWebDriverContainerTest {

    @Rule
    public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer();

    @Test
    public void chromeIsStartedIfNoCapabilitiesProvided() {
        assertBrowserNameIs(chrome, "chrome");
    }

    @Test
    public void simpleExploreTestWhenNoCapabilitiesProvided(){
        doSimpleExplore(chrome);
    }
}