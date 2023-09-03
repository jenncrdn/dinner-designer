package main.java.activity;

import main.java.dao.models.Meal;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

public class CreateRequestActivity {
    private ArrayList<Meal> requestedMeals;

    @Inject
    public CreateRequestActivity() {
        requestedMeals = new ArrayList<>();
    }


    public ArrayList<Meal> getRequestedMeals() {
        return requestedMeals;
    }

    public void resetRequestedMeals() {
        for (Meal m : requestedMeals) {
            requestedMeals.remove(m);
        }
    }

    public Meal handleRequest(final Meal meal) {
        requestedMeals.add(meal);
        return meal; }
}
