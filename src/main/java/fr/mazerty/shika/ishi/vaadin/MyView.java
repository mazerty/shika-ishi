package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

import static com.vaadin.ui.Notification.Type.ERROR_MESSAGE;

public abstract class MyView extends VerticalLayout implements View {

    public void navigateTo(String navigationState) {
        getUI().getNavigator().navigateTo(navigationState);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    public void handleFailure(Throwable throwable) {
        // TODO : log exception
        Notification.show(throwable.getMessage(), ERROR_MESSAGE);
    }

}
