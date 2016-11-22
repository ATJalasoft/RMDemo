package org.jalasoft.roommanager.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jalasoft.roommanager.ui.browser.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * This class contains the common procedures to manage Add, and Delete elements from different components:
 * Leads, Campaign, Account, Contact, ContractHome, Products.
 */
public final class CommonActions {

    private static final Logger LOGGER = LogManager.getLogger(CommonActions.class);

    /**
     * Constructor private.
     */
    private CommonActions() {
    }

    /**
     * This method waits and clickElement the element.
     *
     * @param element Element to wait and clickElement.
     */
    public static void clickElement(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * This method waits and fill the element.
     *
     * @param element Element to wait and fill.
     * @param value    value to fill.
     */
    public static void sendKeys(final WebElement element, final String value) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }


    /**
     * This method waits and clickElement the element.
     *
     * @param element Element to wait and clickElement.
     * @return text to element.
     */
    public static String getText(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

}
