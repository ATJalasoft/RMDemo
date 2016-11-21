package org.jalasoft.roommanager.ui.pages;

import org.jalasoft.roommanager.ui.browser.DriverManager;

import org.jalasoft.roommanager.utils.Environment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class set  the user name and password in the main page and login.
 */
public class LoginPage extends AbstractBasePage {

    @FindBy(id = "ctl00_MainContent_LoginControl1_TextBoxEmail")
    private WebElement usernameTextField;

    @FindBy(css = "div[class='HPHeaderLogin']")
    private WebElement clickLogin;

    @FindBy(id = "ctl00_MainContent_LoginControl1_TextBoxPassword")
    private WebElement passwordTextField;

    @FindBy(id = "ctl00_MainContent_LoginControl1_ButtonLogin")
    private WebElement nextSigningButton;

    /**
     * This method set the username in the text field.
     */
    public void clickLoginButton() {
        clickLogin.click();
    }

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
    public HomePage clickNextButton() {
        nextSigningButton.click();
        return new HomePage();
    }

    /**
     * Method to perform a Logout from Mach2 application.
     */
    public static void clickOnLogOut() {

    }

    /**
     * Method used to perform a login to Mach2 application.
     *
     * @param userName Username used to perform a login to Mach2 application.
     * @param password Password used to perform a login to Mach2 application.
     * @return The login to Mach2 application.
     */
    private static HomePage loginAs(final String userName, final String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.setUsernameTextField(userName);
        loginPage.setPasswordTextField(password);
        return loginPage.clickNextButton();
    }

    /**
     * Method to perform a login with other user.
     *
     * @param userName Username to perform a login with other user.
     * @param password Password to perform a login with other user.
     * @return The login to Mach2 application.
     */
    public static HomePage loginOtherUser(final String userName, final String password) {
        HomePage homePage;
            DriverManager.getInstance().getDriver().get(Environment.getInstance().getBaseUrl());
            homePage = loginAs(userName, password);

        return homePage;
    }

    /**
     * Method to perform a login as Primary user.
     *
     * @return Login to Mach2 application.
     */
    public static HomePage loginAsPrimaryUser() {
        String userNameValue = Environment.getInstance().getPrimaryUser();
        String passwordValue = Environment.getInstance().getPrimaryPassword();
        return loginAs(userNameValue, passwordValue);
    }
}
