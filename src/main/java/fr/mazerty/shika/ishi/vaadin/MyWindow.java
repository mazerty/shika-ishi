package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.ui.Window;

public abstract class MyWindow extends Window implements UiManager {

    public MyWindow(String caption) {
        super(caption);
        center();
    }

    /**
     * Override if some code has to be executed upon opening the window.
     */
    protected void enter() {
    }

}
