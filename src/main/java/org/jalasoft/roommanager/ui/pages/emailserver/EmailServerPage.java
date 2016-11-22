package org.jalasoft.roommanager.ui.pages.emailserver;

import org.jalasoft.roommanager.ui.pages.AbstractBasePage;
import org.jalasoft.roommanager.utils.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Angela Valdez on 11/22/2016.
 */
public class EmailServerPage extends AbstractBasePage {
    @FindBy(linkText = "Add")
    private WebElement addButton;

    /**
     * Click on email server add option.
     * @return {@link EmailServerForm}.
     */
    public EmailServerForm clickAddNewServer() {
        CommonActions.clickElement(addButton);
        return new EmailServerForm();
    }
}
