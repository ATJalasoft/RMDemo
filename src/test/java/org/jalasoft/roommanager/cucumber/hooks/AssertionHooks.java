package org.jalasoft.roommanager.cucumber.hooks;

import cucumber.api.java.Before;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

/**
 * Class that instantiate the assertion according the requirements.
 */
public final class AssertionHooks {

    private static Assertion assertion;

    /**
     * Private constructor.
     */
    private AssertionHooks() {
    }

    /**
     * Instances a normal assert object.
     */
    @Before(order = 2)
    public static void setUp() {
        assertion = new Assertion();
    }

    /**
     * Instances a soft assert object.
     */
    @Before(value = "@softAssert")
    public static void setUpSoftAssert() {
        assertion = new SoftAssert();
    }

    /**
     * Returns the assertion instance.
     *
     * @return The assertion instance.
     */
    public static Assertion getAssertion() {
        return assertion;
    }

}
