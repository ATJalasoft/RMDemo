package org.jalasoft.roommanager.cucumber.stepdefinition.ui.resources;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import java.util.Map;
import org.jalasoft.roommanager.ui.admin.menus.Sidebar;
import org.jalasoft.roommanager.ui.admin.pages.resource.ResourceEnum;
import org.jalasoft.roommanager.ui.admin.pages.resource.ResourceForm;
import org.jalasoft.roommanager.ui.admin.pages.resource.ResourcesPage;

/**
 * This class is to the steps definitions of resources.
 */
public class CreateResource {

    private ResourcesPage resourcesPage;
    private ResourceForm resourceForm;

    private Map<ResourceEnum, String> resourceValues;

    /**
     * This is step definitions to log.
     */
    @Given("^I go to the resource page$")
    public void goToResourcesPage() {
        Sidebar sidebar = new Sidebar();
        resourcesPage = sidebar.goToResources();
    }

    /**
     * Fill all fields to the Resource page.
     *
     * @param resourceData Map whit the resource data.
     */
    @When("^I create a resource with the following values$")
    public void fillTheResourcesForm(final Map<ResourceEnum, String> resourceData) {
        resourceValues = resourceData;
        resourceForm = resourcesPage.clickOnAddResourceButton();
        resourceForm.fillTheForm(resourceData);
        resourcesPage.clickOnSaveButton();
    }

    /**
     * This method.
     *
     * @return ba.
     */
    public Map<ResourceEnum, String> getResourceValues() {
        return resourceValues;
    }

}
