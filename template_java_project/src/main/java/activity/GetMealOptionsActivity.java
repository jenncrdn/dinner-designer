package main.java.activity;

import main.java.dao.MealDao;
import main.java.dao.models.Meal;
import main.java.dao.models.Option;

import javax.inject.Inject;
import java.util.ArrayList;

public class GetMealOptionsActivity {
    private final MealDao mealDao;


    @Inject
    public GetMealOptionsActivity(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    public ArrayList<Meal> handleGetOptionsRequest() {
        ArrayList<Meal> mealOptions = new ArrayList<>();
        ArrayList<Option> optionsMealIds = mealDao.getOptions();
        for (Option o : optionsMealIds) {
            mealOptions.add(mealDao.getMeal(o.getMealId()));
        }
        return mealOptions;
    }
}
