package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.navigator.View;
import com.vaadin.ui.VerticalLayout;

public abstract class MyView extends VerticalLayout implements View, WindowManager {

    protected MyView() {
        setSizeFull();
    }

}
