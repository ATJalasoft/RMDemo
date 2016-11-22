package org.jalasoft.roommanager.ui.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Alvaro Daza on 11/21/2016.
 */
public class FireFox implements Driver {


    @Override
    public WebDriver initDriver() {
        return new FirefoxDriver();
    }
}
