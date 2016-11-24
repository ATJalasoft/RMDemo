package org.jalasoft.roommanager.ui.admin.pages.resource;

import java.util.List;
import org.jalasoft.roommanager.ui.AbstractBasePage;
import org.jalasoft.roommanager.utils.CommonActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import org.openqa.selenium.support.FindBy;

/**
 * Created by Alvaro Daza on 11/21/2016.
 */
public class ResourcesPage extends AbstractBasePage {


    @FindBy(css = "button[class=\"btn btn-default btn-sm\"]")
    @CacheLookup
    private WebElement addResourceButton;

    @FindBy(css = "button[ng-click=\"save()\"]")
    @CacheLookup
    private WebElement resourceSaveButton;

    @FindBy(id = "btnRemove")
    @CacheLookup
    private WebElement resourceDeleteButton;

    @FindBy(css = "div[class=\"ngCell centeredColumn col2 colt2\"] span[class=\"ng-binding\"]")
    @CacheLookup
    private List<WebElement> allResourcesTable;

    @FindBy(css = "div[class=\"ngCell centeredColumn col2 colt2\"] span[class=\"ng-binding\"]")
    @CacheLookup
    private List<WebElement> allResourcesTable2;

    @FindBy(css = "button[class=\"info\"]")
    @CacheLookup
    private WebElement modalDialogRemoveButton;

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

        CommonActions.clickElement(resourceDeleteButton);

    }

    /**
     * Find a especific resource and return a boolean if the resource exist.
     *
     * @param resourceName String whit the name of the resource.
     * @return boolean.
     */
    public boolean findResource(final String resourceName) {

       return allResourcesTable2.stream()
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

        allResourcesTable.forEach(index -> {
            if (index.getText().equals(resourceName)) {
                index.click();
            }
        });

    }

}
