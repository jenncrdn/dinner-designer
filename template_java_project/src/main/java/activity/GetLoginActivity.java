package main.java.activity;

import main.java.dao.UserDao;

import javax.inject.Inject;

public class GetLoginActivity {
    private UserDao userDao;

    @Inject
    public GetLoginActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    public GetLoginActivity() {
    }

    public boolean handleRequest(String username, String password) {
        return userDao.login(username, password);
    }
}
