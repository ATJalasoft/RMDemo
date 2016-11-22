package org.jalasoft.roommanager.ui.pages;


import org.jalasoft.roommanager.ui.pages.menu.TopMenu;

/**
 * Class that display the main page of Room Manager.
 */
public class HomePage extends AbstractBasePage {

    /**
     * Method that go to Top menu.
     *
     * @return The Top menu.
     */
    public TopMenu goToTopMenu() {
        return new TopMenu();
    }
}
