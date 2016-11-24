package org.jalasoft.roommanager.cucumber.stepdefinition.ui.resources;

import static org.jalasoft.roommanager.ui.admin.pages.resource.ResourceEnum.NAME;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Then;
import org.jalasoft.roommanager.ui.admin.pages.resource.ResourcesPage;
import org.jalasoft.roommanager.utils.CommonActions;

/**
 * This class is to assert of resources.
 */
public class AssertResources {
    private CreateResource resource;

    /**
     * This construct is to recover the dates of resources.
     *
     * @param datesResource asdas.
     */
    public AssertResources(final CreateResource datesResource) {
       resource = datesResource;
    }

    /**
     * This assert verify if the resource was created.
     */
    @Then("^The resource is created$")
    public void existResource() {
        ResourcesPage resourcesPage = new ResourcesPage();
        assertTrue(resourcesPage.findResource(resource.getResourceValues().get(NAME)));
    }

    /**
     * This assert verify if the resource was deleted.
     */
    @Then("^The resource is deleted$")
    public void deleteResource() {
        ResourcesPage resourcesPage = new ResourcesPage();
        resourcesPage.clickOnCheckBox(resource.getResourceValues().get(NAME));
        resourcesPage.clickOnDeleteButton();
        resourcesPage.clickOnRemoveButtonModalDialog();
        CommonActions.waitHalfSecond();
        assertFalse(resourcesPage.findResource(resource.getResourceValues().get(NAME)));
    }
}
