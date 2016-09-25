package fr.mazerty.shika.ishi.vaadin;

import fr.mazerty.shika.ishi.bean.User;
import fr.mazerty.shika.ishi.session.Session;
import javaslang.control.Try;

import javax.inject.Inject;

public class LoginWindow extends MyWindow {

    private final MyBeanFieldGroup<User> bfg;
    private final MyLoginForm loginForm;

    @Inject
    private Session session;

    public LoginWindow() {
        super("Login");

        bfg = new MyBeanFieldGroup<>(User.class);

        loginForm = new MyLoginForm(bfg);
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

    @Override
    void enter() {
        bfg.setBean(new User());
        loginForm.focus();
    }

}
