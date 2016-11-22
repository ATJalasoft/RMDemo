package org.jalasoft.roommanager.ui.pages;

import java.util.List;
import org.jalasoft.roommanager.utils.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class  is in charge to manage resources actions.
 */
public class ResourcesPage extends AbstractBasePage {

    @FindBy(css = "input[ng-model=\"resource.name\"]")
    private WebElement resourceNameTextField;

    @FindBy(css = "input[ng-model=\"resource.customName\"]")
    private WebElement resourceDisplayNameTextField;

    @FindBy(css = "textarea[ng-model=\"resource.description\"]")
    private WebElement resourceDescriptionTextField;


    @FindBy(css = "button[class=\"btn btn-default btn-sm\"]")
    private WebElement addResourceButton;

    @FindBy(css = "button[ng-click=\"save()\"]")
    private WebElement resourceSaveButton;

    @FindBy(id = "btnRemove")
    private WebElement resourceDeleteButton;

    @FindBy(className = "ngCanvas")
    private WebElement allResourcesTable;

    @FindBy(css = "button[class=\"info\"]")
    private WebElement modalDialogRemoveButton;


    /**
     * Set the values of the resource.
     *
     * @param resourceName        String whit tne resources name.
     * @param resourceDisplayName String that's the way the resource will be displayed.
     * @param resourceDescription String whit the description's resource.
     */
    public void setResourcesValues(final String resourceName, final String resourceDisplayName,
                                   final String resourceDescription) {
        CommonActions.sendKeys(resourceNameTextField, resourceName);
        CommonActions.sendKeys(resourceDisplayNameTextField, resourceDisplayName);
        CommonActions.sendKeys(resourceDescriptionTextField, resourceDescription);
    }

    /**
     * Click on the add resource option.
     */
    public void clickOnAddResourceButton() {
        CommonActions.clickElement(addResourceButton);
    }

    /**
     * Click on the save button.
     */
    public void clickOnSaveButton() {
        CommonActions.clickElement(resourceSaveButton);

    }

    /**
     * Click on the Delete button.
     */
    public void clickOnDeleteButton() {
        resourceDeleteButton.click();
    }

    /**
     * Find a especific resource and return a boolean if the resource exist.
     *
     * @param resourceName String whit the name of the resource.
     * @return boolean.
     */
    public boolean findResource(final String resourceName) {
        List<WebElement> resourcesList = allResourcesTable
                .findElements(By.xpath("//span[contains(.,'" + resourceName + "')]"));
        return resourcesList.stream()
                .filter(x -> x.getText().equals(resourceName))
                .findAny().isPresent();
    }

    /**
     * Click on remove of the modal dialog.
     */
    public void clickOnRemoveButtonModalDialog() {
        CommonActions.clickElement(modalDialogRemoveButton);
    }

    /**
     * Click on the checkbox of an especific resource.
     *
     * @param resourceName String the name of the resource.
     */
    public void clickOnCheckBox(final String resourceName) {
        List<WebElement> resourcesList = allResourcesTable
                .findElements(By.cssSelector(" div[ng-style=\"rowStyle(row)\"]"));
        for (WebElement elementRow : resourcesList) {
            if (elementRow.findElement(By.xpath("//span[contains(text(),'" + resourceName + "')]"))
                    .getText().equals(resourceName)) {
                CommonActions.clickElement(elementRow);

            }

        }

    }

}
