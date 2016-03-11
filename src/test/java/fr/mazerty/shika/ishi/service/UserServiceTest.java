package fr.mazerty.shika.ishi.service;

import fr.mazerty.shika.ishi.bean.User;
import fr.mazerty.shika.ishi.cdi.DSLContextProducer;
import fr.mazerty.shika.ishi.dao.MyDao;
import fr.mazerty.shika.ishi.dao.UserDao;
import fr.mazerty.shika.ishi.dao.UserDaoImpl;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class UserServiceTest {

    @Inject
    private UserDao userDao;

    @Deployment
    public static WebArchive deployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(User.class, DSLContextProducer.class, MyDao.class, UserDao.class, UserDaoImpl.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("web.xml")
                .addAsLibraries(Maven.resolver().loadPomFromFile("pom.xml").resolve("org.jooq:jooq").withTransitivity().asFile());
    }

    @Test
    public void authenticate() {
        userDao.selectByEmailAndApplication(new User(), "torii");
    }

}
