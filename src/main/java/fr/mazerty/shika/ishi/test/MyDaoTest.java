package fr.mazerty.shika.ishi.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.PomEquippedResolveStage;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.io.File;

@RunWith(Arquillian.class)
public abstract class MyDaoTest {

    public static final String WEB_INF = "src/main/webapp/WEB-INF/";

    @Inject
    private DSLContext dslContext;

    @Deployment
    public static WebArchive deployment() {
        PomEquippedResolveStage pers = Maven.resolver().loadPomFromFile("pom.xml");

        return ShrinkWrap.create(WebArchive.class)
                .addPackages(true, "fr.mazerty.shika")
                .addAsWebInfResource(new File(WEB_INF + "beans.xml"))
                .addAsWebInfResource(new File(WEB_INF + "web.xml"))
                .addAsLibraries(pers.resolve("org.jooq:jooq").withTransitivity().asFile())
                .addAsLibraries(pers.resolve("org.assertj:assertj-core").withTransitivity().asFile());
    }

    protected void delete(Table... tables) {
        dslContext.transaction(configuration -> {
            for (Table table : tables) {
                dslContext.delete(table).execute();
            }
        });
    }

    protected void insert(TableRecord... records) {
        dslContext.transaction(configuration -> {
            for (TableRecord record : records) {
                dslContext.executeInsert(record);
            }
        });
    }

}
