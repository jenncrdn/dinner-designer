package main.java.activity;

import main.java.Protein;
import main.java.ServedWith;
import main.java.dao.MealDao;
import main.java.dao.models.Meal;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Random;

@Singleton
public class CreateMealOptionsActivity {
    private MealDao mealDao;
    private CreateRequestActivity requests;
    private ArrayList<Meal> weeklyMealOptions;
    private int numberOfMeals = 8;
    private int chickenCount;
    private int pastaCount;

    @Inject
    public CreateMealOptionsActivity(MealDao mealDao, CreateRequestActivity requests) {
        this.mealDao = mealDao;
        this.requests = requests;
    }

    public CreateMealOptionsActivity() {
    }

    public ArrayList<Meal> getWeeklyMeals() {
        if (weeklyMealOptions.isEmpty()) {
            createWeeklyMeals();
        }
        return weeklyMealOptions;
    }

    public void createWeeklyMeals() {
        weeklyMealOptions = new ArrayList<>();
        int numOfRequests = 0;

        if (!requests.getRequestedMeals().isEmpty()) {
            weeklyMealOptions.addAll(requests.getRequestedMeals());
            requests.resetRequestedMeals();
            numOfRequests = weeklyMealOptions.size();
        }

        for (int i = numOfRequests; i < numberOfMeals; ) {
            Meal meal = mealDao.getMeal(Integer.toString(getRandomNumber()));

            for (Meal m : weeklyMealOptions) {
                if (m.equals(meal)) {
                    break;
                }
            }

            Protein protein = Protein.valueOf(meal.getProtein());
            if (protein == Protein.CHICKEN) {
                chickenCount++;
                int maxChicken = 2;
                if (chickenCount > maxChicken) {
                    chickenCount--;
                    break;
                }
            }
            ServedWith servedWith = ServedWith.valueOf(meal.getServedWith());
            if (servedWith == ServedWith.PASTA) {
                pastaCount++;
                int maxPasta = 3;
                if (pastaCount > maxPasta) {
                    pastaCount--;
                    break;
                }
            }
            weeklyMealOptions.add(meal);
            i++;
        }
    }

    private int getRandomNumber() {
        int tableSize = mealDao.getTableSize();
        Random random = new Random();
        int randomNumber = random.nextInt();
        return randomNumber % (tableSize) + 101;
    }

    public void setNumberOfMeals(int numberOfMeals) {
        if (numberOfMeals > 0 && numberOfMeals < 10) {
            this.numberOfMeals = numberOfMeals;
        }
        throw new IndexOutOfBoundsException("Please select a number between 1 and 10");
    }

    public void resetMealOptions() {
        for (Meal m : weeklyMealOptions) {
            weeklyMealOptions.remove(m);
        }
    }

    public ArrayList<Meal> handleCreatePlanRequest(final int numberOfMeals) {
        setNumberOfMeals(numberOfMeals);
        createWeeklyMeals();
        return weeklyMealOptions; }

    public ArrayList<Meal> handleGetOptionsRequest() {
        return weeklyMealOptions;
    }
}
