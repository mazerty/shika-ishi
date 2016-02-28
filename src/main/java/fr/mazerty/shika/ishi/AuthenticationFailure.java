package fr.mazerty.shika.ishi;

public class AuthenticationFailure extends Exception {

    public AuthenticationFailure() {
        super("Wrong email or password");
    }

}
