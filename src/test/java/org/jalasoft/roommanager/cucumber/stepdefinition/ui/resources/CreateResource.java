package org.jalasoft.roommanager.cucumber.stepdefinition.ui.resources;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import java.util.Map;
import org.jalasoft.roommanager.ui.admin.menus.Sidebar;
import org.jalasoft.roommanager.ui.admin.pages.resource.ResourceEnum;
import org.jalasoft.roommanager.ui.admin.pages.resource.ResourceForm;
import org.jalasoft.roommanager.ui.admin.pages.resource.ResourcesPage;

/**
 * Created by Alvaro Daza on 11/21/2016.
 */
public class CreateResource {

     public static Map<ResourceEnum, String> resourceValues;

    /**
     * This is step definitions to log.
     */
    @Given("^I want create a resource$")
    public void goToResourcesPage() {
        Sidebar sidebar = new Sidebar();
        sidebar.goToResources();
    }

    /**
     * Fill all fields to the Resource page.
     *
     * @param resourceData Map whit the resource data.
     */
    @When("^I fill the data whit the following values$")
    public void fillTheResourcesForm(final Map<ResourceEnum, String> resourceData) {
        resourceValues = resourceData;
        ResourcesPage resourcesPage = new ResourcesPage();
        resourcesPage.clickOnAddResourceButton();
        ResourceForm resourceForm = new ResourceForm();
        resourceForm.fillTheForm(resourceData);
        resourcesPage.clickOnSaveButton();
    }

}
