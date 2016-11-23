package org.jalasoft.roommanager.cucumber.hooks;


import cucumber.api.java.Before;
import org.jalasoft.roommanager.ui.admin.pages.login.LoginPage;

/**
 * Class to initialize session.
 */
public final class LoginHook {

    private static boolean beforeAllFlag;

    /**
     * Private constructor.
     */
    private LoginHook() {
    }

    /**
     * Method to Login with the default user.
     */
    @Before(order = 1)
    public static void beforeAll() {
        if (!beforeAllFlag) {
            // Login as Primary
            LoginPage.loginAsPrimaryUser();
            beforeAllFlag = true;
        }
    }
}
