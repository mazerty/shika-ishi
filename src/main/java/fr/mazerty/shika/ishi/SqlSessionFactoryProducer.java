package fr.mazerty.shika.ishi;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.io.IOException;

public class SqlSessionFactoryProducer {

    private static final String MYBATIS_CONFIG_PATH = "mybatis.xml";

    @ApplicationScoped
    @Produces
    public SqlSessionFactory produce() throws IOException {
        return new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(MYBATIS_CONFIG_PATH));
    }

}
