package org.jalasoft.roommanager.ui.pages.emailserver;

import static org.jalasoft.roommanager.ui.pages.emailserver.EmailServerEnum.DOMAIN;
import static org.jalasoft.roommanager.ui.pages.emailserver.EmailServerEnum.USER;
import static org.jalasoft.roommanager.ui.pages.emailserver.EmailServerEnum.PASSWORD;
import static org.jalasoft.roommanager.ui.pages.emailserver.EmailServerEnum.DESCRIPTION;

import java.util.HashMap;
import java.util.Map;
import org.jalasoft.roommanager.ui.pages.AbstractBasePage;
import org.jalasoft.roommanager.ui.pages.Steps;
import org.jalasoft.roommanager.utils.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Angela Valdez on 11/21/2016.
 */
public class EmailServerForm extends AbstractBasePage {

    @FindBy(id = "add-mailserver-hostname")
    @CacheLookup
    private WebElement domainTextField;

    @FindBy(id = "add-mailserver-username")
    @CacheLookup
    private WebElement userTextField;

    @FindBy(id = "add-mailserver-password")
    @CacheLookup
    private WebElement passwordTextField;

    @FindBy(id = "add-mailserver-description")
    @CacheLookup
    private WebElement descriptionTextField;

    @FindBy(css = "div.modal-content button[ng-click='sendRequest()']")
    @CacheLookup
    private WebElement saveButton;

    private EmailServerBuilder emailServerBuilder;

    private Map<String, String> valuesMap;

    /**
     * Contructor by default.
     */
    public EmailServerForm() {
        super();
    }

    /**
     * Constructor that initialize the builder and hash map.
     *
     * @param newEmailServerBuilder {@link EmailServerBuilder}
     */
    public EmailServerForm(final EmailServerBuilder newEmailServerBuilder) {
        valuesMap = new HashMap<>();
        this.emailServerBuilder = newEmailServerBuilder;
    }

    /**
     * This method obtains values the Map set.
     *
     * @return A map with values set on "product" form.
     */
    public Map<String, String> getValuesMap() {
        return valuesMap;
    }

    /**
     * This method sets the domain.
     *
     * @param domain is the new name of the domain.
     * @return {@link EmailServerForm}.
     */
    public EmailServerForm setDomain(final String domain) {
        CommonActions.sendKeys(domainTextField, domain);
        return this;
    }

    /**
     * This method sets the user name to create an e-mail server.
     *
     * @param user is a string name.
     * @return {@link EmailServerForm}.
     */
    public EmailServerForm setUserServer(final String user) {
        CommonActions.sendKeys(userTextField, user);
        return this;
    }

    /**
     * This method sets the password to create an e-mail server.
     *
     * @param password is a string name.
     * @return {@link EmailServerForm}.
     */
    public EmailServerForm setPasswordServer(final String password) {
        CommonActions.sendKeys(passwordTextField, password);
        return this;
    }

    /**
     * This method sets the description to create an e-mail server.
     *
     * @param description is a string name.
     * @return {@link EmailServerForm}.
     */
    public EmailServerForm setDescriptionServer(final String description) {
        CommonActions.sendKeys(descriptionTextField, description);
        return this;
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate is the map that contains all the values.
     */
    public void fillTheForm(final Map<EmailServerEnum, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }

    /**
     * Method that to permit set values to create a new Email Server.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the email server created.
     */
    public Map<EmailServerEnum, Steps> getStrategyStepMap(final Map<EmailServerEnum, String> values) {
        final Map<EmailServerEnum, Steps> strategyMap = new HashMap<>();

        strategyMap.put(DOMAIN, () -> setDomain(values.get(DOMAIN)));
        strategyMap.put(USER, () -> setUserServer(values.get(USER)));
        strategyMap.put(PASSWORD, () -> setPasswordServer(values.get(PASSWORD)));
        strategyMap.put(DESCRIPTION, () -> setDescriptionServer(values.get(DESCRIPTION)));

        return strategyMap;
    }

    /**
     * Clicks on save button of email server form.
     */
    public void clickSaveButton() {
        CommonActions.clickElement(saveButton);
    }


    /**
     * This class handle the builder pattern.
     */
    public static class EmailServerBuilder {

        private String domain;

        private String username;

        private String password;

        private String description;

        private Map<EmailServerEnum, String> strategyMap;

        /**
         * Constructor of the EmailServerBuilder class.
         *
         * @param newDomain   Domain is a required field to create an email server.
         * @param newUsername User is required field to create an email server.
         * @param newPassword Password is a required field field to create an email server.
         */
        public EmailServerBuilder(final String newDomain, final String newUsername, final String newPassword) {
            strategyMap = new HashMap<>();
            this.domain = newDomain;
            this.username = newUsername;
            this.password = newPassword;
            strategyMap.put(DOMAIN, domain);
            strategyMap.put(USER, username);
            strategyMap.put(PASSWORD, password);
            //this.OWNER_EXPIRATION_NOTICE = "--None--";
        }

        /**
         * Sets the description field in the form.
         *
         * @param newDescription Is the description of the email server.
         * @return {@link EmailServerBuilder}
         */
        public EmailServerBuilder setDescription(final String newDescription) {
            this.description = newDescription;
            strategyMap.put(DESCRIPTION, description);
            return this;
        }

        /**
         * Returns the value of the description.
         *
         * @return the description of the form.
         */
        public String getDescription() {
            return description;
        }

        /**
         * Sets the customer domain in the form.
         *
         * @param newDomain Is the new domain.
         * @return {@link EmailServerBuilder}
         */
        public EmailServerBuilder setDomain(final String newDomain) {
            this.domain = newDomain;
            strategyMap.put(DOMAIN, domain);
            return this;
        }

        /**
         * Returns the value of the domain.
         *
         * @return the domain of the form.
         */
        public String getDomain() {
            return domain;
        }

        /**
         * Sets the custom username in the form.
         *
         * @param newUsername Is the new username.
         * @return {@link EmailServerBuilder}
         */
        public EmailServerBuilder setUserServer(final String newUsername) {
            this.username = newUsername;
            strategyMap.put(USER, username);
            return this;
        }

        /**
         * Returns the value of the username.
         *
         * @return the username of the form.
         */
        public String getUserServer() {
            return username;
        }

        /**
         * Sets the customer password in the form.
         *
         * @param newPassword Is the new password.
         * @return {@link EmailServerBuilder}
         */
        public EmailServerBuilder setPasswordServer(final String newPassword) {
            this.password = newPassword;
            strategyMap.put(PASSWORD, password);
            return this;
        }

        /**
         * Returns the value of the password.
         *
         * @return the password of the form.
         */
        public String getPasswordServer() {
            return password;
        }

        /**
         * This method set the strategyMap contract.
         *
         * @return A map with values set on "contract" form.
         */
        public Map<EmailServerEnum, String> getStrategyMap() {
            return strategyMap;
        }

        /**
         * Builds the builder pattern design.
         *
         * @return {@link EmailServerForm}
         */
        public EmailServerForm build() {
            return new EmailServerForm(this);
        }

    }
}
