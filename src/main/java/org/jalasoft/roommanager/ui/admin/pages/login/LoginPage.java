package org.jalasoft.roommanager.ui.admin.pages.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jalasoft.roommanager.ui.AbstractBasePage;
import org.jalasoft.roommanager.ui.admin.menus.Sidebar;
import org.jalasoft.roommanager.ui.admin.menus.TopMenu;
import org.jalasoft.roommanager.ui.browser.DriverManager;
import org.jalasoft.roommanager.utils.Environment;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class set  the user name and password in the main page and login.
 */
public class LoginPage extends AbstractBasePage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

    @FindBy(id = "loginUsername")
    private WebElement usernameTextField;

    @FindBy(id = "loginPassword")
    private WebElement passwordTextField;

    @FindBy(css = "button.btn")
    private WebElement singInButton;

    /**
     * This method set the username in the text field.
     *
     * @param username String whit the username.
     */
    public void setUsernameTextField(final String username) {
        usernameTextField.clear();
        usernameTextField.sendKeys(username);
    }

    /**
     * This method set the password in the text field.
     *
     * @param password String  whit the password.
     */
    public void setPasswordTextField(final String password) {
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
    }

    /**
     * Method to click on next button.
     *
     * @return The home page.
     */
    public Sidebar clickSignInButton() {
        singInButton.click();
        return new Sidebar();

    }

    /**
     * Method used to perform a login to Mach2 application.
     *
     * @param userName Username used to perform a login to Mach2 application.
     * @param password Password used to perform a login to Mach2 application.
     * @return The login to Room Manager application.
     */
    private static Sidebar loginAs(final String userName, final String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.setUsernameTextField(userName);
        loginPage.setPasswordTextField(password);
        return loginPage.clickSignInButton();
    }

    /**
     * Method to perform a login with other user.
     *
     * @param userName Username to perform a login with other user.
     * @param password Password to perform a login with other user.
     * @return The login to Room Manager application.
     */

    public static Sidebar loginOtherUser(final String userName, final String password) {
        Sidebar sidebar = new Sidebar();
        try {
            TopMenu topMenu = new TopMenu();
            if (!topMenu.isUserLogged(topMenu.getUserName())) {
                topMenu.logout();
                sidebar = loginAs(userName, password);
            }
        } catch (WebDriverException e) {
            DriverManager.getInstance().getDriver().get(Environment.getInstance().getBaseUrl());
            sidebar = loginAs(userName, password);
            LOGGER.info("A user was already logged", e);
        }
        return sidebar;
    }

    /**
     * Method to perform a login as Primary user.
     *
     * @return Login to Room Manager application.
     */
    public static Sidebar loginAsPrimaryUser() {
        String userNameValue = Environment.getInstance().getPrimaryUser();
        String passwordValue = Environment.getInstance().getPrimaryPassword();
        return loginOtherUser(userNameValue, passwordValue);
    }
}
