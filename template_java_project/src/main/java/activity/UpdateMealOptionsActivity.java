package main.java.activity;

import main.java.dao.models.Meal;
import main.java.exceptions.VotedOffMealTieException;

import javax.inject.Inject;
import java.util.ArrayList;

public class UpdateMealOptionsActivity {

    private CreateMealOptionsActivity mealOptions;
    private ArrayList<Meal> finalMealPlan;
    private Meal mostVotes;

    @Inject
    public UpdateMealOptionsActivity(CreateMealOptionsActivity mealOptions) {
        this.mealOptions = mealOptions;
        finalMealPlan = new ArrayList<>();
    }

    public UpdateMealOptionsActivity() {
    }

    private void setMostVotes() {
        mostVotes = mealOptions.getWeeklyMeals().get(0);
        for (Meal m : mealOptions.getWeeklyMeals()) {
            if (m.getVotes() > mostVotes.getVotes()) {
                mostVotes = m;
            }
            if(m.getVotes() == mostVotes.getVotes()) {
                throw new VotedOffMealTieException("We have a tie! " + m.getMealName() + " and " + mostVotes.getMealName());
            }
        }
    }

    private void removeMostVotes() {
        setMostVotes();
        ArrayList<Meal> meals =  mealOptions.getWeeklyMeals();
        meals.remove(mostVotes);
        finalMealPlan = meals;
        mealOptions.resetMealOptions();
    }

    public ArrayList<Meal> getFinalMealPlan() {
        removeMostVotes();
        return finalMealPlan;
    }
    public ArrayList<Meal> handleRequest() {return getFinalMealPlan(); }


}
