package fr.mazerty.shika.ishi;

public interface UserDao {

    User selectByEmailAndApplication(User user, String application);

}
