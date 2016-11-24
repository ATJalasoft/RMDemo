package org.jalasoft.roommanager.ui.admin.menus;

import org.jalasoft.roommanager.ui.AbstractBasePage;
import org.jalasoft.roommanager.ui.admin.pages.resource.ResourcesPage;
import org.jalasoft.roommanager.ui.admin.pages.emailserver.EmailServerPage;
import org.jalasoft.roommanager.utils.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class is is in charge to manage all Available application options .
 */
public class Sidebar extends AbstractBasePage {

    @FindBy(xpath = "//a[contains(.,'Resources')]")
    private WebElement resourcesMenuButton;

    @FindBy(linkText = "Email Servers")
    private WebElement emailServersMenuButton;

    /**
     * Click on resources Option.
     * @return {@link ResourcesPage}.
     */
    public ResourcesPage goToResources() {
        CommonActions.clickElement(resourcesMenuButton);
        return new ResourcesPage();
    }

    /**
     * Click on email server Option.
     * @return {@link EmailServerPage}.
     */
    public EmailServerPage goToEmailServers() {
        CommonActions.clickElement(emailServersMenuButton);
        return new EmailServerPage();
    }
}
