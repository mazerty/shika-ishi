/**
 * This class is generated by jOOQ
 */
package fr.mazerty.shika.ishi.dao.jooq;


import fr.mazerty.shika.ishi.dao.jooq.tables.TApplication;
import fr.mazerty.shika.ishi.dao.jooq.tables.TUser;
import fr.mazerty.shika.ishi.dao.jooq.tables.TUserApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Torii extends SchemaImpl {

    private static final long serialVersionUID = 1240300781;

    /**
     * The reference instance of <code>torii</code>
     */
    public static final Torii TORII = new Torii();

    /**
     * The table <code>torii.t_application</code>.
     */
    public final TApplication T_APPLICATION = fr.mazerty.shika.ishi.dao.jooq.tables.TApplication.T_APPLICATION;

    /**
     * The table <code>torii.t_user</code>.
     */
    public final TUser T_USER = fr.mazerty.shika.ishi.dao.jooq.tables.TUser.T_USER;

    /**
     * The table <code>torii.t_user_application</code>.
     */
    public final TUserApplication T_USER_APPLICATION = fr.mazerty.shika.ishi.dao.jooq.tables.TUserApplication.T_USER_APPLICATION;

    /**
     * No further instances allowed
     */
    private Torii() {
        super("torii", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
            Sequences.S_USER_ID);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            TApplication.T_APPLICATION,
            TUser.T_USER,
            TUserApplication.T_USER_APPLICATION);
    }
}
