package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.navigator.View;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public abstract class MyView extends VerticalLayout implements View {

    protected MyView() {
        setSizeFull();
    }

    protected void addWindow(Window window) {
        MyUI.getCurrent().addWindow(window);
    }

}
