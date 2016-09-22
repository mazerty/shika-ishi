package fr.mazerty.shika.ishi.vaadin;

import fr.mazerty.shika.ishi.bean.User;
import fr.mazerty.shika.ishi.session.Session;
import javaslang.control.Try;

import javax.inject.Inject;

public class LoginWindow extends MyWindow {

    @Inject
    private Session session;

    public LoginWindow() {
        super("Login");

        MyBeanFieldGroup<User> bfg = new MyBeanFieldGroup<>(User.class);

        MyLoginForm loginForm = new MyLoginForm(bfg);
        loginForm.addLoginListener(event -> Try
                .of(bfg::getBean)
                .andThenTry(session::login)
                .andThen(() -> navigateTo(MyUI.MAIN_VIEW_NAME))
                .onFailure(this::handleFailure)
        );

        setContent(loginForm);
        setClosable(false);
        setResizable(false);
    }

}
