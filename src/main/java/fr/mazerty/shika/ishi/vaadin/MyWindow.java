package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;

import static com.vaadin.ui.Notification.Type.ERROR_MESSAGE;

public abstract class MyWindow extends Window {

    public MyWindow(String caption) {
        super(caption);

        center();
    }

    protected void navigateTo(String navigationState) {
        MyUI.getCurrent().getNavigator().navigateTo(navigationState);
    }

    void handleFailure(Throwable throwable) {
        // TODO : log exception
        Notification.show(throwable.getMessage(), ERROR_MESSAGE);
    }

}
