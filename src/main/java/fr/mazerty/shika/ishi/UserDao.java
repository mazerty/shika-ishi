package fr.mazerty.shika.ishi;

import org.apache.ibatis.annotations.Param;

public interface UserDao {

    User selectByEmailAndApplication(@Param("user") User user, @Param("application") String application);

}
