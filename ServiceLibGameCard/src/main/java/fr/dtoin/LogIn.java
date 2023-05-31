package fr.dtoin;

public class LogIn {
    private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    private String password;
    public LogIn(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public LogIn() {
        this.username = "";
        this.password = "";
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}