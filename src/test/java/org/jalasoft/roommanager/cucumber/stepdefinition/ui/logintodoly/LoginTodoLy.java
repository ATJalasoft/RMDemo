package org.jalasoft.roommanager.cucumber.stepdefinition.ui.logintodoly;

import cucumber.api.java.en.When;
import org.jalasoft.roommanager.ui.pages.LoginPage;

/**
 * This class is to demo.
 */
public class LoginTodoLy {

    /**
     * This is step definitions to log.
     */
    @When("^I login$")
    public void iLoginSiQueSi() {
        LoginPage login = new LoginPage();
      //  login.clickLoginButton();
        login.loginAsPrimaryUser();
    }

}
