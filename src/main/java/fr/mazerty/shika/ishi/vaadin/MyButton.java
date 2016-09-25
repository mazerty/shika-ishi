package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.ui.Button;

import static com.vaadin.event.ShortcutAction.KeyCode.ENTER;
import static com.vaadin.ui.themes.ValoTheme.BUTTON_PRIMARY;

public class MyButton extends Button {

    public MyButton(String caption) {
        super(caption);
    }

    public void setPrimary() {
        addStyleName(BUTTON_PRIMARY);
        setClickShortcut(ENTER);
    }

}
