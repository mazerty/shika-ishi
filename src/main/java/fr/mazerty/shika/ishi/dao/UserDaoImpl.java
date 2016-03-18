package fr.mazerty.shika.ishi.dao;

import fr.mazerty.shika.ishi.bean.User;
import fr.mazerty.shika.ishi.dao.jooq.Tables;
import fr.mazerty.shika.ishi.dao.jooq.tables.TApplication;
import fr.mazerty.shika.ishi.dao.jooq.tables.TUser;
import fr.mazerty.shika.ishi.dao.jooq.tables.TUserApplication;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserDaoImpl extends MyDao implements UserDao {

    @Override
    public User selectByEmailAndApplication(User user, String application) {
        TUser u = Tables.T_USER;
        TUserApplication ua = Tables.T_USER_APPLICATION;
        TApplication a = Tables.T_APPLICATION;

        return dslContext.select().from(u)
                .innerJoin(ua).on(ua.USER_FK.equal(u.ID))
                .innerJoin(a).on(a.ID.equal(ua.APPLICATION_FK))
                .where(u.EMAIL.equal(user.getEmail()))
                .and(a.NAME.equal(application))
                .fetchAnyInto(User.class);
    }

}
