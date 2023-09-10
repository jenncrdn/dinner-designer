package main.java.activity;

import main.java.Protein;
import main.java.ServedWith;
import main.java.dao.MealDao;
import main.java.dao.models.Meal;
import main.java.dao.models.Option;
import main.java.dao.models.Request;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Random;

@Singleton
public class CreateMealOptionsActivity {
    private MealDao mealDao;
    private static ArrayList<Meal> weeklyMealOptions = new ArrayList<>();
    private int numberOfMeals;
    private int chickenCount;
    private int pastaCount;

    @Inject
    public CreateMealOptionsActivity(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    public CreateMealOptionsActivity() {

    }

    public ArrayList<Option> getWeeklyMeals() {
        return mealDao.getOptions();
    }

    public void createWeeklyMeals() {
        weeklyMealOptions = new ArrayList<>();
        mealDao.removeOptions();

        ArrayList<Request> requests = mealDao.getRequests();
        int numOfRequests = requests.size();
        mealDao.removeRequests();

        for (Request r : requests) {
            Option option = new Option();
            option.setMealId(r.getMealId());
            mealDao.saveOptions(option);
            weeklyMealOptions.add(mealDao.getMeal(r.getMealId()));
        }

        if (numOfRequests < numberOfMeals) {
            for (int i = numOfRequests; i < numberOfMeals; ) {
                Meal meal = mealDao.getMeal(Integer.toString(getRandomNumber()));

                if (weeklyMealOptions.contains(meal)) {
                    continue;
                }

                String protein = meal.getProtein();
                String servedWith = meal.getServedWith();
                boolean containsChicken;
                boolean containsPasta;
                try {
                    containsChicken = protein.equalsIgnoreCase(String.valueOf(Protein.CHICKEN));
                } catch (NullPointerException e) {
                    containsChicken = false;
                }

                try {
                    containsPasta = servedWith.equalsIgnoreCase(String.valueOf(ServedWith.PASTA));
                } catch (NullPointerException e) {
                    containsPasta = false;
                }

                int maxChicken = 2;
                int maxPasta = 3;
                if ((containsChicken && chickenCount >= maxChicken) || (containsPasta && pastaCount >= maxPasta)) {
                    continue;
                }

                if (containsChicken) {
                    chickenCount++;
                }

                if (containsPasta) {
                    pastaCount++;
                }

                weeklyMealOptions.add(meal);
                i++;
                Option option = new Option();
                option.setMealId(meal.getMealId());
                mealDao.saveOptions(option);
            }
        }
    }

    public int getRandomNumber() {
        int tableSize = mealDao.getTableSize();
        Random random = new Random();
        int randomNumber = random.nextInt(100000);
        int numToUse = (randomNumber % tableSize) + 101;
        return numToUse;
    }

    public void setNumberOfMeals(int numberOfMeals) {
        if (numberOfMeals > 0 && numberOfMeals <= 10) {
            this.numberOfMeals = numberOfMeals;
        } else {
            throw new IndexOutOfBoundsException("Please select a number between 1 and 10");
        }
    }

    public int getNumberOfMeals() {
        return numberOfMeals;
    }

    public ArrayList<Meal> handleCreatePlanRequest(final Integer numberOfMeals) {
        setNumberOfMeals(numberOfMeals);
        createWeeklyMeals();
        return weeklyMealOptions;
    }
}
