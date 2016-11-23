package org.jalasoft.roommanager.cucumber.stepdefinition.ui.emailserver;

import static org.jalasoft.roommanager.ui.admin.pages.emailserver.EmailServerEnum.DOMAIN;
import static org.jalasoft.roommanager.ui.admin.pages.emailserver.EmailServerEnum.PASSWORD;
import static org.jalasoft.roommanager.ui.admin.pages.emailserver.EmailServerEnum.USER;

import cucumber.api.java.en.Given;
import java.util.HashMap;
import java.util.Map;
import org.jalasoft.roommanager.ui.admin.menus.Sidebar;
import org.jalasoft.roommanager.ui.admin.pages.emailserver.EmailServerEnum;
import org.jalasoft.roommanager.ui.admin.pages.emailserver.EmailServerForm;
import org.jalasoft.roommanager.ui.admin.pages.emailserver.EmailServerPage;
import org.jalasoft.roommanager.utils.Environment;

/**
 * Email server steps.
 */
public class EmailServer {

    /**
     * Adds a new email server with data provided by the user.
     * @param emailServerData Is the data to fill the form to add the email server.
     */
    @Given("^I add an email server with the data$")
    public void iAddAnEmailServerWithTheData(final Map<EmailServerEnum, String> emailServerData) {
        Sidebar sideBar = new Sidebar();
        EmailServerPage emailServerPage = sideBar.goToEmailServers();
        EmailServerForm emailServerForm = emailServerPage.clickAddNewServer();
        emailServerForm.fillTheForm(emailServerData);
        emailServerForm.clickSaveButton();
    }

    /**
     * Adds a new email server with data provided the properties file.
     */
    @Given("^I add an email server by default$")
    public void iAddAnEmailServerByDefault() {
        Environment environment = Environment.getInstance();
        String domain = environment.getDomain();
        String username = environment.getUserServer();
        String password = environment.getPasswordServer();

        Map<EmailServerEnum, String> emailServerData = new HashMap<>();
        emailServerData.put(DOMAIN, domain);
        emailServerData.put(USER, username);
        emailServerData.put(PASSWORD, password);
        iAddAnEmailServerWithTheData(emailServerData);
    }
}
