/**
 * This class is generated by jOOQ
 */
package fr.mazerty.shika.ishi.dao.jooq;


import fr.mazerty.shika.ishi.dao.jooq.tables.TApplication;
import fr.mazerty.shika.ishi.dao.jooq.tables.TUser;
import fr.mazerty.shika.ishi.dao.jooq.tables.TUserApplication;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in torii
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

	/**
	 * The table torii.t_application
	 */
	public static final TApplication T_APPLICATION = fr.mazerty.shika.ishi.dao.jooq.tables.TApplication.T_APPLICATION;

	/**
	 * The table torii.t_user
	 */
	public static final TUser T_USER = fr.mazerty.shika.ishi.dao.jooq.tables.TUser.T_USER;

	/**
	 * The table torii.t_user_application
	 */
	public static final TUserApplication T_USER_APPLICATION = fr.mazerty.shika.ishi.dao.jooq.tables.TUserApplication.T_USER_APPLICATION;
}