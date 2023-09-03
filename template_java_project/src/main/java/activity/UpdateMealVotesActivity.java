package main.java.activity;

import main.java.dao.models.Meal;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UpdateMealVotesActivity {

    @Inject
    public UpdateMealVotesActivity() {
        ;
    }

    private void voteForMeal(Meal meal) {
        int votes = meal.getVotes();
        votes++;
        meal.setVotes(votes);
    }

    public Meal handleRequest(final Meal meal) {
        voteForMeal(meal);
        return meal; }
}
