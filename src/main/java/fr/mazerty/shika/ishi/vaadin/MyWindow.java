package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.ui.Component;
import com.vaadin.ui.Window;

public class MyWindow extends Window {

    public MyWindow(String caption, Component content) {
        super(caption, content);

        center();
    }

}
