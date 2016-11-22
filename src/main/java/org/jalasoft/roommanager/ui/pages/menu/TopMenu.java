package org.jalasoft.roommanager.ui.pages.menu;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jalasoft.roommanager.ui.pages.AbstractBasePage;
import org.jalasoft.roommanager.ui.pages.LoginPage;
import org.jalasoft.roommanager.utils.Environment;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class to manage the Top menu Room Manager.
 */
public class TopMenu extends AbstractBasePage {

    private static final int MIN_TIMEOUT = 3;

    private static final Logger LOGGER = LogManager.getLogger(TopMenu.class);


    @FindBy(css = "span.ng-binding")
    private WebElement userLoggedName;

    @FindBy(linkText = "sign out")
    private WebElement logOutButton;


    /**
     * Method to get the user name.
     *
     * @return The user name.
     */
    public String getUserName() {
        String userLogged = "";

        try {
            driver.manage().timeouts().implicitlyWait(MIN_TIMEOUT, TimeUnit.SECONDS);
            wait.withTimeout(MIN_TIMEOUT, TimeUnit.SECONDS);
            userLogged = this.userLoggedName.getText();
        } catch (NoSuchElementException e) {
            LOGGER.error("Couldn't find the user name on top menu");
            throw new WebDriverException(e);
        } finally {
            driver.manage().timeouts().implicitlyWait(Environment.getInstance().getTimeout(), TimeUnit.SECONDS);
            wait.withTimeout(Environment.getInstance().getTimeout(), TimeUnit.SECONDS);
        }
        return userLogged;
    }

     /**
     * Method to knows if the user is logged.
     *
     * @param account The user account.
     * @return The user account.
     */
    public boolean isUserLogged(final String account) {
        return getUserName().equals(account);
    }

    /**
     * Method to perform the logout of Mach2.
     *
     * @return The login page.
     */
    public LoginPage logout() {
        logOutButton.click();
        return new LoginPage();
    }

}
