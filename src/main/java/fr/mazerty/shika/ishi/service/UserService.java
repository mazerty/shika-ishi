package fr.mazerty.shika.ishi.service;

import fr.mazerty.shika.ishi.bean.User;
import fr.mazerty.shika.ishi.exception.AuthenticationFailure;

import java.io.Serializable;

public interface UserService extends Serializable {

    User authenticate(User user) throws AuthenticationFailure;

}
