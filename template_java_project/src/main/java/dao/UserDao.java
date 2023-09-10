package main.java.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.dao.models.User;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserDao {
    private final DynamoDBMapper mapper;

    @Inject
    public UserDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Gets a user by username.
     * @param username The username of the user to look up
     * @return the User
     */
    public User getUserByUsername(String username) {
        return mapper.load(User.class, username);
    }

    /**
     * Saves a new User to the table.
     * @param username The ID of the user to save
     * @return the UserId
     */
    public User registerNewUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAdmin(false);

        mapper.save(user);
        return user;
    }
    public boolean login(String username, String password) {
        User user = getUserByUsername(username);
        return user.getPassword().equals(password);
    }
}
