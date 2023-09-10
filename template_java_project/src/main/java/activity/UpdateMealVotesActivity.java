package main.java.activity;

import main.java.dao.MealDao;
import main.java.dao.models.Meal;
import main.java.dao.models.Option;

import javax.inject.Inject;
import java.util.ArrayList;

public class UpdateMealVotesActivity {

    private final MealDao mealDao;

    @Inject
    public UpdateMealVotesActivity(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    private void voteForMeal(Meal meal) {
        Option option = mealDao.getOption(meal.getMealId());
        int votes = option.getVotes();
        votes++;
        option.setVotes(votes);
        mealDao.saveOptions(option);
    }

    public Meal handleRequest(final Meal meal) {
        voteForMeal(meal);
        return meal;
    }
}
