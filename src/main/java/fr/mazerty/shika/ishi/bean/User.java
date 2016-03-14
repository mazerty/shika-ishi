package fr.mazerty.shika.ishi.bean;

public class User {

    private Integer id;
    private String email;
    private String password = ""; // initialisé à "" car jbcrypt plante sur une chaîne null

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
