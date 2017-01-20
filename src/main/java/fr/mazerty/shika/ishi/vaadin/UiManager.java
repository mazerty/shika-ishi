package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.ui.UI;

interface UiManager {

    default void show(MyWindow window) {
        UI.getCurrent().addWindow(window);
        window.enter();
    }

    default void navigateTo(String navigationState) {
        UI.getCurrent().getNavigator().navigateTo(navigationState);
    }

}
