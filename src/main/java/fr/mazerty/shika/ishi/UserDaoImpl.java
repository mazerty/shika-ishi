package fr.mazerty.shika.ishi;

import javax.enterprise.context.ApplicationScoped;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

@ApplicationScoped
public class UserDaoImpl extends MyDao implements UserDao {

    @Override
    public User selectByEmailAndApplication(User user, String application) {
        return dslContext.select()
                .from(table("torii.t_user").as("u"))
                .innerJoin(table("torii.t_user_application").as("ua"))
                .on(field("u.id").equal(field("ua.user_fk")))
                .innerJoin(table("torii.t_application").as("a"))
                .on(field("ua.application_fk").equal(field("a.id")))
                .where(field("u.email").equal(user.getEmail()))
                .and(field("a.name").equal(application))
                .fetchOne().into(User.class);
    }

}
