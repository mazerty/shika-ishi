package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import javaslang.control.Option;

import static com.vaadin.ui.Notification.Type.ERROR_MESSAGE;

public abstract class MyView extends VerticalLayout implements View {

    private Option<MyWindow> mainWindow;

    protected MyView() {
        mainWindow = Option.none();

        setSizeFull();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    protected void navigateTo(String navigationState) {
        getUI().getNavigator().navigateTo(navigationState);
    }

    void handleFailure(Throwable throwable) {
        // TODO : log exception
        Notification.show(throwable.getMessage(), ERROR_MESSAGE);
    }

    public Option<MyWindow> getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(MyWindow mainWindow) {
        this.mainWindow = Option.of(mainWindow);
    }

}
