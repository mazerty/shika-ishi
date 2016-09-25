package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.ui.*;
import fr.mazerty.shika.ishi.bean.User;

import static com.vaadin.ui.themes.ValoTheme.BUTTON_PRIMARY;

class MyLoginForm extends LoginForm {

    private MyBeanFieldGroup<User> bfg;
    private MyTextField email;

    MyLoginForm(MyBeanFieldGroup<User> bfg) {
        this.bfg = bfg;
    }

    @Override
    protected TextField createUsernameField() {
        return email = bfg.buildAndBind("Email", "email", MyTextField.class);
    }

    @Override
    protected PasswordField createPasswordField() {
        return bfg.buildAndBind("Password", "password", PasswordField.class);
    }

    @Override
    protected Button createLoginButton() {
        Button login = new Button("Log in");
        login.addStyleName(BUTTON_PRIMARY);

        return login;
    }

    @Override
    protected Component createContent(TextField userNameField, PasswordField passwordField, Button loginButton) {
        FormLayout formLayout = new FormLayout(userNameField, passwordField, loginButton);
        formLayout.setSizeUndefined();
        formLayout.setMargin(true);

        return formLayout;
    }

    @Override
    public void focus() {
        email.focus();
    }

}
