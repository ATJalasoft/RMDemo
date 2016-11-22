package org.jalasoft.roommanager.unittest;

import static org.jalasoft.roommanager.cucumber.hooks.AssertionHooks.getAssertion;

import org.jalasoft.roommanager.utils.DataTimeManager;
import org.testng.annotations.Test;


/**
 * This class ......
 */
public class DataTimeManagerTest {

    private String expectedValue = "";

    /**
     * test for the getDataTimeForCreateAProject method.
     */
    @Test
    public final void testDataTime() {
        expectedValue = "2016-08-23";
        getAssertion().assertEquals(expectedValue, DataTimeManager.getDataTimeForCreateAProject());
    }

    /**
     * test for the parserDataTimeToFirstFormat method.
     */
    @Test
    public final void testParserDataTimeToFirstFormat() {
        expectedValue = "May 30, 2016";
        String dataTimeFirstFormat = "2016-05-30";
        getAssertion().assertEquals(expectedValue, DataTimeManager.parserDataTimeToFirstFormat(dataTimeFirstFormat));
    }

    /**
     * test for the parserDataTimeToSecondFormat method.
     */
    @Test
    public final void testParserDataTimeToSecondFormat() {
        expectedValue = "Sep 13, 2016";
        String dataTimeSecondFormat = "2016-09-13T12:00:05Z";
        getAssertion().assertEquals(expectedValue, DataTimeManager.parserDataTimeToSecondFormat(dataTimeSecondFormat));
    }

}
