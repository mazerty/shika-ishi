package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.cdi.CDIView;
import fr.mazerty.shika.ishi.bean.User;
import fr.mazerty.shika.ishi.session.Session;
import javaslang.control.Try;

import javax.inject.Inject;

/**
 * Cette vue est automatiquement présentée lors de la connexion à l'application
 */
@CDIView(LoginView.VIEW_NAME)
public class LoginView extends MyView {

    public static final String VIEW_NAME = "login";

    @Inject
    private Session session;

    public LoginView() {
        MyBeanFieldGroup<User> bfg = new MyBeanFieldGroup<>(User.class);

        MyLoginForm loginForm = new MyLoginForm(bfg);
        loginForm.addLoginListener(event -> Try
                .of(bfg::getBean)
                .andThenTry(session::login)
                .andThen(() -> navigateTo(MyUI.MAIN_VIEW_NAME))
                .onFailure(this::handleFailure)
        );

        MyWindow window = new MyWindow("Login", loginForm);
        window.setClosable(false);
        window.setResizable(false);
        setMainWindow(window);
    }

}
