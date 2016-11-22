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
            // Login as Primary
            //   Sidebar sidebar = LoginPage.loginAsPrimaryUser();
            //  sidebar.goToTopMenu();
            LoginPage.loginAsPrimaryUser();

            beforeAllFlag = true;
        }
    }
}
