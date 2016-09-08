package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.cdi.CDIView;
import com.vaadin.ui.Notification;
import fr.mazerty.shika.ishi.bean.User;
import fr.mazerty.shika.ishi.session.Session;
import javaslang.control.Try;

import javax.inject.Inject;

import static com.vaadin.ui.Alignment.MIDDLE_CENTER;
import static com.vaadin.ui.Notification.Type.ERROR_MESSAGE;

/**
 * Cette vue est automatiquement présentée lors de la connexion à l'application
 */
@CDIView(LoginView.VIEW_NAME)
public class LoginView extends MyView {

    public static final String VIEW_NAME = "login";

    private final MyLoginForm myLoginForm;

    @Inject
    private Session session;

    public LoginView() {
        MyBeanFieldGroup<User> bfg = new MyBeanFieldGroup<>(User.class);

        myLoginForm = new MyLoginForm(bfg);
        myLoginForm.addLoginListener(event -> Try
                .of(bfg::getBean)
                .andThenTry(session::login)
                .andThen(() -> navigateTo(MyUI.MAIN_VIEW_NAME))
                .onFailure(e -> Notification.show(e.getMessage(), ERROR_MESSAGE)) // TODO
        );

        setSizeFull();
        addComponent(myLoginForm);
        setComponentAlignment(myLoginForm, MIDDLE_CENTER);
    }

}
