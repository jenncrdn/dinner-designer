package main.java.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.dao.models.User;

public class UserDao {
    private DynamoDBMapper mapper;

    public UserDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Gets a user by ID.
     * @param userId The ID of the user to look up
     * @return the User
     */
    public User getUser(String userId) {
        return mapper.load(User.class, userId);
    }
}
