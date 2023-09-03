package main.java.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import main.java.dao.models.Meal;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages access to Meal items.
 */
public class MealDao {
    private DynamoDBMapper mapper;

    @Inject
    public MealDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Gets a meal by ID.
     * @param mealId The ID of the meal to look up
     * @return the Meal
     */
    public Meal getMeal(String mealId) {
        return mapper.load(Meal.class, mealId);
    }

    /**
     * Gets a meal by mealName.
     * @param mealName The name of the meal to look up
     * @return the Meal
     */
    public Meal getMealByName(String mealName) {
        return mapper.load(Meal.class, mealName);
    }

    public ArrayList<Meal> getAllMealNames() {
        PaginatedScanList<Meal> allMeals = mapper.scan(Meal.class, new DynamoDBScanExpression());
        return new ArrayList<>(allMeals);
    }

    public int getTableSize() {
        return mapper.count(Meal.class, new DynamoDBScanExpression());
    }
}
