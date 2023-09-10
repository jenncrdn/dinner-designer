package main.java.activity;

import main.java.dao.MealDao;
import main.java.dao.models.Meal;
import main.java.dao.models.MealPlan;
import main.java.dao.models.Option;
import main.java.exceptions.VotedOffMealTieException;

import javax.inject.Inject;
import java.util.ArrayList;

public class UpdateMealOptionsActivity {

    private MealDao mealDao;
    private Meal mostVotes;
    private static final ArrayList<Meal> finalMealPlan = new ArrayList<>();

    @Inject
    public UpdateMealOptionsActivity(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    public UpdateMealOptionsActivity() {
    }

    private void setMostVotes() {
        ArrayList<Option> options = mealDao.getOptions();
        mostVotes = mealDao.getMeal(options.get(0).getMealId());
        for (Option o : options) {
            if (o.getVotes() > mostVotes.getVotes()) {
                mostVotes = mealDao.getMeal(o.getMealId());
            }
            if (o.getVotes() == mostVotes.getVotes()) {
                throw new VotedOffMealTieException("We have a tie! " +
                        mealDao.getMeal(o.getMealId()).getMealName() + " and " + mostVotes.getMealName());
            }
        }
    }

    private void removeMostVotes() {
        setMostVotes();
        ArrayList<Option> meals = mealDao.getOptions();
        meals.remove(mostVotes.getMealId());
        mealDao.removeMealPlan();
        for (Option o : meals) {
            MealPlan mealPlan = new MealPlan();
            mealPlan.setMealId(o.getMealId());
            mealDao.saveMealPlan(mealPlan);
            finalMealPlan.add(mealDao.getMeal(o.getMealId()));
        }
    }

    public ArrayList<Meal> getFinalMealPlan() {
        removeMostVotes();
        return finalMealPlan;
    }
    public ArrayList<Meal> handleRequest() {
        return getFinalMealPlan(); }


}
