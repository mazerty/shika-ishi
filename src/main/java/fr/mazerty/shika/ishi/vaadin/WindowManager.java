package fr.mazerty.shika.ishi.vaadin;

interface WindowManager {

    default void show(MyWindow window) {
        MyUI.getCurrent().addWindow(window);
        window.enter();
    }

}
