package Models;

public class User {
    private String UserName;
    private String Password;
    private String Type;

    public User(String userName, String password, String type) {
        UserName = userName;
        Password = password;
        Type = type;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
