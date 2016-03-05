package fr.mazerty.shika.ishi;

import org.jooq.DSLContext;

import javax.inject.Inject;

public abstract class MyDao {

    @Inject
    protected DSLContext dslContext;

}
