package main.java.controllers;

import main.java.entities.Meal;
import main.java.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class MealController {
    @Autowired
    MealRepository mealRepo;

    @GetMapping("{mealId}")
    public Meal findById(@PathVariable(value = "mealId") String mealId) {
        return mealRepo.findById(mealId);
    }

    @GetMapping("{mealName}")
    public Meal findByMealName(@PathVariable(value = "mealName") String mealName) {
        return mealRepo.findByMealName(mealName);
    }
}
