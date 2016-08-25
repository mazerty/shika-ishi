package fr.mazerty.shika.ishi.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.archive.importer.MavenImporter;
import org.jboss.shrinkwrap.resolver.api.maven.strategy.AcceptAllStrategy;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public abstract class MyDaoTest {

    @Inject
    private DSLContext dslContext;

    @Deployment
    public static WebArchive deployment() {
        return ShrinkWrap.create(MavenImporter.class)
                .loadPomFromFile("pom.xml")
                .importBuildOutput(AcceptAllStrategy.INSTANCE)
                .as(WebArchive.class);
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
