package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.ui.UI;

interface WindowManager {

    default void show(MyWindow window) {
        UI.getCurrent().addWindow(window);
        window.enter();
    }

}
