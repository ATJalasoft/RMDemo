package org.jalasoft.roommanager.ui.admin.pages.resource;

import static org.jalasoft.roommanager.ui.admin.pages.resource.ResourceEnum.DISPLAY_NAME;
import static org.jalasoft.roommanager.ui.admin.pages.resource.ResourceEnum.NAME;
import static org.jalasoft.roommanager.ui.admin.pages.resource.ResourceEnum.RESOURCE_DESCRIPTION;

import java.util.HashMap;
import java.util.Map;
import org.jalasoft.roommanager.ui.AbstractBasePage;
import org.jalasoft.roommanager.ui.Steps;
import org.jalasoft.roommanager.utils.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alvaro Daza on 11/23/2016.
 */
public class ResourceForm extends AbstractBasePage {


    @FindBy(css = "input[ng-model=\"resource.name\"]")
    @CacheLookup
    private WebElement resourceNameTextField;

    @FindBy(css = "input[ng-model=\"resource.customName\"]")
    @CacheLookup
    private WebElement resourceDisplayNameTextField;

    @FindBy(css = "textarea[ng-model=\"resource.description\"]")
    @CacheLookup
    private WebElement resourceDescriptionTextField;

    /**
     * Set the resource Name.
     *
     * @param resourceName String The resource name.
     * @return ResourceForm.
     */
    public ResourceForm setName(final String resourceName) {
        CommonActions.sendKeys(resourceNameTextField, resourceName);
        return this;
    }

    /**
     * Set the resource display name.
     *
     * @param resourceDisplayName String resource display name.
     * @return ResourceForm.
     */
    public ResourceForm setDisplayName(final String resourceDisplayName) {
        CommonActions.sendKeys(resourceDisplayNameTextField, resourceDisplayName);
        return this;
    }

    /**
     * Set the resource description.
     *
     * @param resourceDescription String The resource description.
     * @return ResourceForm.
     */
    public ResourceForm setDescription(final String resourceDescription) {
        CommonActions.sendKeys(resourceDescriptionTextField, resourceDescription);
        return this;
    }


    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate is the map that contains all the values.
     */
    public void fillTheForm(final Map<ResourceEnum, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }

    /**
     * Method that to permit set values to create a new Email Server.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the email server created.
     */
    public Map<ResourceEnum, Steps> getStrategyStepMap(final Map<ResourceEnum, String> values) {
        final Map<ResourceEnum, Steps> strategyMap = new HashMap<>();

        strategyMap.put(NAME, () -> setName(values.get(NAME)));
        strategyMap.put(DISPLAY_NAME, () -> setDisplayName(values.get(DISPLAY_NAME)));
        strategyMap.put(RESOURCE_DESCRIPTION, () -> setDescription(values.get(RESOURCE_DESCRIPTION)));

        return strategyMap;
    }


}
