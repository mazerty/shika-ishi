package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * View-based {@link UI} with a default {@link Navigator}.
 */
public abstract class ViewUI extends UI {

    protected Navigator navigator;

    @Override
    protected void init(VaadinRequest request) {
        // defines that the application consists of a set of annotated views you can access through the ui's navigator
        navigator = new Navigator(this, this);
        navigator.addViewChangeListener(new WindowCloserViewChangeListener());
    }

}
