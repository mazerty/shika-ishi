package fr.mazerty.shika.ishi.dao;

import fr.mazerty.shika.ishi.bean.User;

public interface UserDao {

    User selectByEmailAndApplication(User user, String application);

}
