package org.jalasoft.roommanager.ui.pages.emailserver;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jalasoft.roommanager.ui.pages.AbstractBasePage;
import org.jalasoft.roommanager.utils.CommonActions;
import org.jalasoft.roommanager.utils.Environment;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Angela Valdez on 11/22/2016.
 */
public class EmailServerPage extends AbstractBasePage {
    private static final int MIN_TIMEOUT = 3;

    private static final Logger LOGGER = LogManager.getLogger(EmailServerPage.class);

    @FindBy(css = "button[ng-click='openModal()']")
    @CacheLookup
    private WebElement addButton;

    @FindBy(css = "button[ng-click='openDeleteDialog()']")
    @CacheLookup
    private WebElement removeButton;

    @FindBy(css = "button[ng-click='onYes()']")
    @CacheLookup
    private WebElement confirmDelete;

    /**
     * Click on email server add option.
     *
     * @return {@link EmailServerForm}.
     */
    public EmailServerForm clickAddNewServer() {
        try {
            driver.manage().timeouts().implicitlyWait(MIN_TIMEOUT, TimeUnit.SECONDS);
            wait.withTimeout(MIN_TIMEOUT, TimeUnit.SECONDS);
            CommonActions.clickElement(addButton);
        } catch (WebDriverException e) {
            LOGGER.info("Add a new server when another is already added.");
            clickRemoveEmailServer();
            CommonActions.clickElement(addButton);
        } finally {
            driver.manage().timeouts().implicitlyWait(Environment.getInstance().getTimeout(), TimeUnit.SECONDS);
            wait.withTimeout(Environment.getInstance().getTimeout(), TimeUnit.SECONDS);
        }
        return new EmailServerForm();
    }

    /**
     * Deletes an email server.
     * @return {@link EmailServerPage}
     */
    public EmailServerPage clickRemoveEmailServer() {
        CommonActions.clickElement(removeButton);
        CommonActions.clickElement(confirmDelete);
        return new EmailServerPage();
    }
}
