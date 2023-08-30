package main.java;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import main.java.entities.Meal;
import main.java.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Random;

public class MealPlan {
    @Autowired
    private DynamoDBMapper mapper;
    //= new DynamoDBConfiguration().dynamoDBMapper();
//    private DynamoDBConfiguration dbConfig;//= new DynamoDBConfiguration().dynamoDBMapper();
    @Autowired
    MealRepository mealRepo;
    private ArrayList<Meal> weeklyMeals;
    private int numberOfMeals = 8;
    private int chickenCount;
    private int pastaCount;
    private Meal mostVotes;

    public MealPlan(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public MealPlan(DynamoDBMapper mapper, int numberOfMeals) {
        this.mapper = mapper;
        this.numberOfMeals = numberOfMeals;
    }

    public ArrayList<Meal> getWeeklyMeals() {
        return weeklyMeals;
    }

    public void createWeeklyMeals() {
        for (int i = 0; i < numberOfMeals; ) {
            Meal meal = mapper.load(Meal.class, Integer.toString(getRandomNumber()));
//            Meal meal = mealRepo.findById(Integer.toString(getRandomNumber()));
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
            weeklyMeals.add(meal);
            i++;
        }
    }

    private int getRandomNumber() {
        int tableSize = getTableSize();
        Random random = new Random();
        int randomNumber = random.nextInt();
        return randomNumber % (tableSize + 100) + 101;
    }

    private int getTableSize() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        return mapper.count(Meal.class, scanExpression);
    }

    private void voteForMeal() {

    }

    private void removeMostVotes() {
        weeklyMeals.remove(mostVotes);
    }

    private ArrayList<Meal> searchForMeal(String userInput) {
        return null;
    }
}
