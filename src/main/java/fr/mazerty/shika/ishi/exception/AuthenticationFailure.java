package fr.mazerty.shika.ishi.exception;

public class AuthenticationFailure extends Exception {

    public AuthenticationFailure() {
        super("Wrong email or password");
    }

}
