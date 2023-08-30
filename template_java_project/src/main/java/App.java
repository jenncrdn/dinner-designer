package main.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        MealPlan mealPlan = new MealPlan(8);
        mealPlan.createWeeklyMeals();
        System.out.println(mealPlan.getWeeklyMeals());
    }
}
