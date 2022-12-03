package Models;
/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class User {

    public static String firstName;

    public static String lastName;

    public static String email;

    public static String role;
    public static String password;

    private String Password;

    private String Type;
    private String UserName;


    public User(String userName, String password, String type) {
        UserName = userName;
        Password = password;
        Type = type;
    }

    public User(String firstName, String lastName, String email, String role, String password) {

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
