package org.jalasoft.roommanager.cucumber.hooks;

import static org.jalasoft.roommanager.ui.admin.pages.resource.ResourceEnum.NAME;

import cucumber.api.java.After;
import org.jalasoft.roommanager.cucumber.stepdefinition.ui.resources.CreateResource;
import org.jalasoft.roommanager.ui.admin.pages.resource.ResourcesPage;

/**
 * Created by Alvaro Daza on 11/24/2016.
 */
public class DeleteResourceHook {
    private CreateResource resource;

    /**
     * Constructor.
     * @param dataResource CreateResource
     */
    public DeleteResourceHook(final CreateResource dataResource) {
        resource = dataResource;
    }

    /**
     *Delete the resource created.
     */
    @After(value = "@deleteResource")
    public void deleteResource() {
        ResourcesPage resourcesPage = new ResourcesPage();
        resourcesPage.clickOnCheckBox(resource.getResourceValues().get(NAME));
        resourcesPage.clickOnDeleteButton();
        resourcesPage.clickOnRemoveButtonModalDialog();
    }
}
