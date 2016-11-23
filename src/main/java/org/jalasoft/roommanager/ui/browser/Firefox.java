package org.jalasoft.roommanager.ui.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

/**
 * Created by Alvaro Daza on 11/21/2016.
 */
public class FireFox implements Driver {
    private static final String WEB_DRIVER_PATH = "webdrivers/geckodriver.exe";
    private static final String WEB_DRIVER_KEY = "webdriver.gecko.driver";

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initDriver() {
        System.setProperty(WEB_DRIVER_KEY, WEB_DRIVER_PATH);

        ProfilesIni allProfiles = new ProfilesIni();
        // Use FirefoxProfile Constructor
        FirefoxProfile myProfile = allProfiles.getProfile("default");
        myProfile.setAcceptUntrustedCertificates(true);
        myProfile.setAssumeUntrustedCertificateIssuer(false);

        return new FirefoxDriver(myProfile);
    }
}
