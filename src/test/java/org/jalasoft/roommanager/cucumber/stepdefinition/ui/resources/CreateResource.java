package org.jalasoft.roommanager.cucumber.stepdefinition.ui.resources;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.jalasoft.roommanager.ui.admin.menus.Sidebar;
import org.jalasoft.roommanager.ui.admin.pages.resource.ResourcesPage;

/**
 * Created by Alvaro Daza on 11/21/2016.
 */
public class CreateResource {


    /**
     * This is step definitions to log.
     */
    @Given("^I want create a resource$")
    public void goToResourcesPage() {
        Sidebar sidebar = new Sidebar();
        sidebar.goToResources();
    }

    /**
     * create a resource.
     *
     * @param resourceName        String whit the name of the resource.
     * @param resourceDisplayName String Whit the name of the resource that will be displayed.
     * @param resourceDescription String whit the resource description.
     */
    @When("^I create the resource whit the name: (.*) ,display name: (.*) and description: (.*)$")
    public void createResource(final String resourceName, final String resourceDisplayName,
                               final String resourceDescription) {
        ResourcesPage resourcesPage = new ResourcesPage();
        resourcesPage.clickOnAddResourceButton();
        resourcesPage.setResourcesValues(resourceName, resourceDisplayName, resourceDescription);
        resourcesPage.clickOnSaveButton();
    }

    /**
     * Verify if the resource exist.
     *
     * @param resourceName String resources name.
     */
    @Then("^The resource (.*) is created$")
    public void existResource(final String resourceName) {
        ResourcesPage resourcesPage = new ResourcesPage();
        assertTrue(resourcesPage.findResource(resourceName));

    }

    /**
     * Delete a resource.
     *
     * @param resourceName String the resources name.
     */
    @Then("^The resource (.*) is deleted$")
    public void deleteResource(final String resourceName) {
        ResourcesPage resourcePage = new ResourcesPage();
        resourcePage.clickOnCheckBox(resourceName);
        resourcePage.clickOnDeleteButton();
        resourcePage.clickOnRemoveButtonModalDialog();

    }

}
