package org.jalasoft.roommanager.cucumber.stepdefinition.ui.resources;

import static org.jalasoft.roommanager.cucumber.stepdefinition.ui.resources.CreateResource.resourceValues;
import static org.jalasoft.roommanager.ui.admin.pages.resource.ResourceEnum.NAME;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Then;
import org.jalasoft.roommanager.ui.admin.pages.resource.ResourcesPage;
import org.jalasoft.roommanager.utils.CommonActions;

/**
 * Created by Alvaro Daza on 11/23/2016.
 */
public class AssertResources {

    CreateResource createResource;
    ResourcesPage resourcesPage;
    /**
     *
     */
    @Then("^The resource is created$")
    public void existResource() {
        ResourcesPage resourcesPage = new ResourcesPage();
        assertTrue(resourcesPage.findResource(resourceValues.get(NAME)));


    }

    /**
     *
     */
    @Then("^The resource is deleted$")
    public void deleteResource() {
        ResourcesPage resourcesPage = new ResourcesPage();
        resourcesPage.clickOnCheckBox(resourceValues.get(NAME));
        resourcesPage.clickOnDeleteButton();
        resourcesPage.clickOnRemoveButtonModalDialog();
        CommonActions.waitHalfSecond();
        assertFalse(resourcesPage.findResource(resourceValues.get(NAME)));
    }
}
