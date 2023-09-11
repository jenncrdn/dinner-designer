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
    private Option mostVotes;
    private ArrayList<Option> options;
    private static final ArrayList<Meal> finalMealPlan = new ArrayList<>();

    @Inject
    public UpdateMealOptionsActivity(MealDao mealDao) {
        this.mealDao = mealDao;
        options = mealDao.getOptions();
    }

    public UpdateMealOptionsActivity() {
    }

    private void setMostVotes() {
        mostVotes = options.get(0);
        for (Option o : options) {
            if (o.getVotes() > mostVotes.getVotes()) {
                mostVotes = o;
            }
//            if (o.getVotes() == mostVotes.getVotes() && !o.getMealId().equals(mostVotes.getMealId())) {
//                throw new VotedOffMealTieException("We have a tie! " +
//                        mealDao.getMeal(o.getMealId()).getMealName() + " and " + mostVotes.getMealName());
//            }
        }
    }

    private void removeMostVotes() {
        setMostVotes();
        options.remove(mostVotes);
    }

    public ArrayList<Meal> getFinalMealPlan() {
        removeMostVotes();
        mealDao.removeMealPlan();

        for (Option o : options) {
            MealPlan mealPlan = new MealPlan();
            mealPlan.setMealId(o.getMealId());
            mealDao.saveMealPlan(mealPlan);
            finalMealPlan.add(mealDao.getMeal(o.getMealId()));
        }
        return finalMealPlan;
    }
    public ArrayList<Meal> handleRequest() {
        return getFinalMealPlan(); }


}
