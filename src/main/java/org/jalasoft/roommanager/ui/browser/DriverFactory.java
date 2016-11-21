package org.jalasoft.roommanager.ui.browser;

import org.openqa.selenium.WebDriverException;

/**
 * This class handle the logic related to what kind of browser.
 */
public final class DriverFactory {

    private static final String BROWSER_NOT_FOUND_MSG = "Browser not found.";

    /**
     * Private constructor.
     */
    private DriverFactory() {
    }

    /**
     * Get Driver to what kind of browser.
     *
     * @param browser kind of driver to return.
     * @return Kind of driver Browser.
     */
    public static Driver getDriver(final Browser browser) {
        switch (browser) {
            case CHROME:
                return new Chrome();
            default:
                throw new WebDriverException(BROWSER_NOT_FOUND_MSG);
        }
    }
}