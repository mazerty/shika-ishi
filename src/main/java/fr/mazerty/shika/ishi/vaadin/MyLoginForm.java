package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.ui.*;
import fr.mazerty.shika.ishi.bean.User;

import static com.vaadin.ui.themes.ValoTheme.BUTTON_PRIMARY;

class MyLoginForm extends LoginForm {

    private static final String FLD_EMAIL_CAPTION = "Email";
    private static final String FLD_PASSWORD_CAPTION = "Password";
    private static final String BTN_LOGIN_CAPTION = "Log in";

    private MyBeanFieldGroup<User> bfg;

    MyLoginForm(MyBeanFieldGroup<User> bfg) {
        this.bfg = bfg;
    }

    @Override
    protected TextField createUsernameField() {
        return bfg.buildAndBind(FLD_EMAIL_CAPTION, "email", MyTextField.class);
    }

    @Override
    protected PasswordField createPasswordField() {
        return bfg.buildAndBind(FLD_PASSWORD_CAPTION, "password", PasswordField.class);
    }

    @Override
    protected Button createLoginButton() {
        Button button = new Button(BTN_LOGIN_CAPTION);
        button.addStyleName(BUTTON_PRIMARY);

        return button;
    }

    @Override
    protected Component createContent(TextField userNameField, PasswordField passwordField, Button loginButton) {
        userNameField.focus();

        FormLayout formLayout = new FormLayout(userNameField, passwordField, loginButton);
        formLayout.setSizeUndefined();
        formLayout.setMargin(true);

        return formLayout;
    }

}
