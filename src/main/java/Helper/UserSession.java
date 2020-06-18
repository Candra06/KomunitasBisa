package Helper;

import java.util.HashSet;
import java.util.Set;

public class UserSession {
    private static UserSession instance;

    private String userName;
    private Set<String> privileges;

    public UserSession(String userNames) {
        this.userName = userName;
    }

    public static UserSession getInstace(String userName) {
        new UserSession(userName);

        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public Set<String> getPrivileges() {
        return privileges;
    }

    public void cleanUserSession() {
        userName = "";// or null
        privileges = new HashSet<>();// or null
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + userName + '\'' +
                ", privileges=" + privileges +
                '}';
    }
}
