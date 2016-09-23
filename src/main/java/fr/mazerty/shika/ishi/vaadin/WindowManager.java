package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.ui.Window;

public interface WindowManager {

    default void addWindow(Window window) {
        MyUI.getCurrent().addWindow(window);
    }

}
