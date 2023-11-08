package main.java.activity;

import main.java.dao.MealDao;
import main.java.dao.models.Meal;
import main.java.dao.models.Request;

import javax.inject.Inject;
import java.util.ArrayList;

public class CreateRequestActivity {
    private static final ArrayList<Meal> requestedMeals = new ArrayList<>();
    private final MealDao mealDao;

    @Inject
    public CreateRequestActivity(MealDao mealDao) {
        this.mealDao = mealDao;
    }


    public ArrayList<Meal> getRequestedMeals() {
        ArrayList<Request> requests = mealDao.getRequests();
        for (Request r : requests) {
            requestedMeals.add(mealDao.getMeal(r.getMealId()));
        }
        return requestedMeals;
    }

    public Meal handleRequest(final Meal meal) {
        System.out.println(meal.getMealId());
        Request request = new Request();
        request.setMealId(meal.getMealId());
        mealDao.saveRequests(request);
        System.out.println(request.getMealId());
        return meal;
    }
}
