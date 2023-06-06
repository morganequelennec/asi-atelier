package fr.dtoout;


public class UserOut {

    private Integer id;
    private String login;
    private String pwd;
    private Double account;
    private String lastName;
    private String surName;
    private String email;

    public UserOut(Integer id, String login, String pwd, Double account, String lastName, String surName, String email, String session) {
        this.id = id;
        this.login = login;
        this.pwd = pwd;
        this.account = account;
        this.lastName = lastName;
        this.surName = surName;
        this.email = email;
        this.session = session;
    }

    public UserOut()
    {

    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    private String session;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}