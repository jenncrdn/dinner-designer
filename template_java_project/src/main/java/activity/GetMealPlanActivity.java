package main.java.activity;

import main.java.dao.MealDao;
import main.java.dao.models.Meal;
import main.java.dao.models.MealPlan;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class GetMealPlanActivity {
    private MealDao mealDao;
    @Inject
    public GetMealPlanActivity(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    public GetMealPlanActivity() {
    }

    public ArrayList<Meal> handleRequest() {
        ArrayList<Meal> meals = new ArrayList<>();
        ArrayList<MealPlan> mealPlan = mealDao.getMealPlan();
        for (MealPlan m : mealPlan) {
        meals.add(mealDao.getMeal(m.getMealId()));
        }
        return meals;
    }
}
