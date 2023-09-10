package main.java.activity;

import main.java.dao.MealDao;
import main.java.dao.models.Meal;
import main.java.dao.models.Option;
import main.java.dao.models.Request;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;

public class CreateRequestActivity {
    private static final ArrayList<Meal> requestedMeals = new ArrayList<>();
    private MealDao mealDao;


    @Inject
    public CreateRequestActivity(MealDao mealDao) {}


    public ArrayList<Meal> getRequestedMeals() {
        ArrayList<Request> requests = mealDao.getRequests();
        for (Request r : requests) {
            requestedMeals.add(mealDao.getMeal(r.getMealId()));
        }
        return requestedMeals;
    }

    public void resetRequestedMeals() {
        mealDao.removeRequests();
    }

    public Meal handleRequest(final Meal meal) {
        Request request = new Request();
        request.setMealId(meal.getMealId());
        mealDao.saveRequests(request);
        return meal;
    }
}
