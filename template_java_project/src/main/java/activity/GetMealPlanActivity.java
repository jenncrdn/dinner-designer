package main.java.activity;

import main.java.dao.models.Meal;

import javax.inject.Inject;
import java.util.ArrayList;

public class GetMealPlanActivity {
    private UpdateMealOptionsActivity mealPlan;
    @Inject
    public GetMealPlanActivity(UpdateMealOptionsActivity mealPlan) {
        this.mealPlan = mealPlan;
    }

    public GetMealPlanActivity() {
    }

    public ArrayList<Meal> handleRequest() {
        return mealPlan.getFinalMealPlan(); }
}
