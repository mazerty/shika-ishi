package fr.mazerty.shika.ishi.service;

import fr.mazerty.shika.ishi.bean.User;
import fr.mazerty.shika.ishi.dao.UserDao;
import fr.mazerty.shika.ishi.exception.AuthenticationFailure;
import org.mindrot.jbcrypt.BCrypt;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    // TODO : generate on startup
    private static final String DUMMY_HASH = "$2a$13$byD4Ftv39Z76hUfd01URsePSdaV722c7J7NcLfs6o3KdJsAwHhEjq";

    @Inject
    private String application;

    @Inject
    private UserDao userDao;

    @Override
    public User authenticate(User user) throws AuthenticationFailure {
        User match = userDao.selectByEmailAndApplication(user, application);
        if (match != null) {
            if (BCrypt.checkpw(user.getPassword(), match.getPassword())) {
                return match;
            } else {
                throw new AuthenticationFailure();
            }
        } else {
            // il ne faut pas qu'il y ait de différence de temps de traitement entre une erreur liée au user
            // et une erreur liée au password, donc on vérifie le password par rapport à un hash bidon
            BCrypt.checkpw(user.getPassword(), DUMMY_HASH);
            throw new AuthenticationFailure();
        }
    }

}
