package org.jalasoft.roommanager.cucumber.stepdefinition.ui;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import java.util.Map;
import org.jalasoft.roommanager.ui.pages.HomePage;
import org.jalasoft.roommanager.ui.pages.emailserver.EmailServerForm;

/**
 * Email server steps.
 */
public class EmailServer {

    @Given("^I add an email server with the data$")
    public void iAddAnEmailServerWithTheData() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I add an email server by default$")
    public void iAddAnEmailServerByDefault( final Map<String, String> emailServerData) {
        HomePage homePage = new HomePage();

        contractForm = new ContractForm.ContractBuilder(
                valuesMapJson.get(ACCOUNT_NAME.toString()), STATUS, CONTRACT_START_DATE, CONTRACT_TERM_MONTHS)
                .build();
        contractDetail = contractForm.saveContract();
        Asserts.assertDetailValues(contractDetail, contractForm.getValuesMap());
    }
}
