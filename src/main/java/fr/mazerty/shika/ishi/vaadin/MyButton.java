package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.ui.Button;

/**
 * Custom {@link Button} with some useful methods
 */
public class MyButton extends Button {

    /**
     * Replaces the current {@link com.vaadin.ui.Button.ClickListener}s
     */
    public void setClickListener(ClickListener clickListener) {
        // first removes the current clicklisteners
        getListeners(ClickListener.class).forEach(listener -> removeClickListener((ClickListener) listener));

        // then adds the new one
        addClickListener(clickListener);
    }

}
