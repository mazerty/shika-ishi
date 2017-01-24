package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.ui.Window;

public abstract class MyWindow extends Window implements UiManager {

    public MyWindow() {
        center();
    }

    /**
     * Override if some code has to be executed upon showing the window.
     */
    protected void enter() {
    }

}
