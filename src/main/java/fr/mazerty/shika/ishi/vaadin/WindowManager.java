package fr.mazerty.shika.ishi.vaadin;

interface WindowManager {

    // TODO : rename
    default void addWindow(MyWindow window) {
        MyUI.getCurrent().addWindow(window);
        window.enter();
    }

}
