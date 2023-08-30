package main.java.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.entities.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MealRepository {
    @Autowired
    private DynamoDBMapper mapper;


    // CREATE

    // READ
    public Meal findById(String mealId) {
        return mapper.load(Meal.class, mealId);
    }

    public Meal findByMealName(String mealName) {
        return mapper.load(Meal.class, mealName);
    }

    // UPDATE

    // DELETE
}
