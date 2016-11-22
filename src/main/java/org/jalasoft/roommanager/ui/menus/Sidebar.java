package org.jalasoft.roommanager.ui.menus;

import org.jalasoft.roommanager.ui.pages.AbstractBasePage;
import org.jalasoft.roommanager.ui.pages.ResourcesPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class is is in charge to manage all Available application options .
 */
public class Sidebar extends AbstractBasePage {

    @FindBy(xpath = "//a[contains(.,'Resources')]")
    private WebElement resourcesMenuButton;

    /**
     * Click on resources Option.
     * @return ResourcesPage.
     */
    public ResourcesPage goToResources() {
        resourcesMenuButton.click();
        return new ResourcesPage();
    }

}
