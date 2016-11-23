package org.jalasoft.roommanager.cucumber.hooks;


import cucumber.api.java.Before;
import org.jalasoft.roommanager.ui.pages.LoginPage;

/**
 * Class to initialize session.
 */
public class LoginHook {

    private static boolean beforeAllFlag;

    /**
     * Method to Login with the default user.
     */
    @Before
    public void beforeAll() {
        if (!beforeAllFlag) {
            LoginPage.loginAsPrimaryUser();
            beforeAllFlag = true;
        }
    }
}
