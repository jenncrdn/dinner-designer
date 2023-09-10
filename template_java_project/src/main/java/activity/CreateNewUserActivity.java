package main.java.activity;

import main.java.dao.UserDao;
import main.java.dao.models.User;

import javax.inject.Inject;

public class CreateNewUserActivity {
    private UserDao userDao;

    @Inject
    public CreateNewUserActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    public CreateNewUserActivity() {
    }

    public User handleRequest(String username, String password) {
        return userDao.registerNewUser(username, password);
    }
}
