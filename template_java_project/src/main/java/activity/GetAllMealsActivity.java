package main.java.activity;

import main.java.dao.MealDao;
import main.java.dao.models.Meal;

import javax.inject.Inject;
import java.util.ArrayList;

public class GetAllMealsActivity {
    private MealDao mealDao;

    @Inject
    public GetAllMealsActivity(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    public GetAllMealsActivity() {
    }

    public ArrayList<Meal> handleRequest() {return mealDao.getAllMealNames(); }
}
