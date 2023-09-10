package main.java.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import main.java.dao.models.Meal;
import main.java.dao.models.MealPlan;
import main.java.dao.models.Option;
import main.java.dao.models.Request;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * Manages access to Meal items.
 */
@Singleton
public class MealDao {

    private final DynamoDBMapper mapper;

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

    public ArrayList<Option> getOptions() {
        PaginatedScanList<Option> options = mapper.scan(Option.class, new DynamoDBScanExpression());
        return new ArrayList<>(options);
    }
    public Option getOption(String mealId) { return mapper.load(Option.class, mealId); }
    public void saveOptions(Option option) { mapper.save(option); }
    public void removeOptions() { mapper.batchDelete(Option.class); }



    public ArrayList<MealPlan> getMealPlan() {
        PaginatedScanList<MealPlan> mealPlan = mapper.scan(MealPlan.class, new DynamoDBScanExpression());
        return new ArrayList<>(mealPlan);
    }

    public void saveMealPlan(MealPlan mealPlan) { mapper.save(mealPlan); }
    public void removeMealPlan() { mapper.batchDelete(MealPlan.class); }


    public ArrayList<Request> getRequests() {
        PaginatedScanList<Request> requests = mapper.scan(Request.class, new DynamoDBScanExpression());
        return new ArrayList<>(requests);
    }
    public void saveRequests(Request request) { mapper.save(request); }
    public void removeRequests() { mapper.batchDelete(Request.class); }

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
