package fr.mazerty.shika.ishi.dao;

import org.jooq.DSLContext;

import javax.inject.Inject;

/**
 * Classe abstraite qui permet aux DaoImpl d'accéder au contexte jOOQ
 */
public abstract class MyDao {

    @Inject
    protected DSLContext dslContext;

}
