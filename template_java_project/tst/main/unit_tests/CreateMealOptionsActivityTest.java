//package main.unit_tests;
//
//import main.java.activity.CreateMealOptionsActivity;
//import main.java.activity.CreateRequestActivity;
//import main.java.dao.MealDao;
//import main.java.dao.models.Meal;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.mockito.MockitoAnnotations.openMocks;
//
//public class CreateMealOptionsActivityTest {
//    @Mock
//    private MealDao mealDao;
//    @Mock
//    private CreateRequestActivity requests;
//
//    private CreateMealOptionsActivity createMealOptionsActivity;
//
//
//    @BeforeEach
//    public void setup() throws Exception {
//        openMocks(this).close();
//        createMealOptionsActivity = new CreateMealOptionsActivity(mealDao, requests);
//    }
//
//    @Test
//    public void setNumberOfMeals_validNum_setsTheNumberOfMeals() {
//        //GIVEN
//        int numOfMeals = 6;
//
//        //WHEN
//        createMealOptionsActivity.setNumberOfMeals(numOfMeals);
//
//        //THEN
//        assertEquals(numOfMeals, createMealOptionsActivity.getNumberOfMeals());
//    }
//
////    @Test
////    public void getWeeklyMealOptions_mealOptionsNotNull_mealArrayReturned() {
////
////    }
//
//    @Test
//    public void handleCreatePlanRequest_givenNumOfMeals_returnsThatNumOfMeals() {
//        //GIVEN
//        Meal meal1 = new Meal();
//        meal1.setMealId("123");
//        meal1.setMealName("Chipotle Bowls");
//        meal1.setProtein("Chicken");
//        meal1.setServedWith("Pasta");
//
//        Meal meal2 = new Meal();
//        meal2.setMealId("154");
//        meal2.setMealName("Meatball Subs");
//        meal2.setProtein("Chicken");
//        meal2.setServedWith("Pasta");
//
//        Meal meal3 = new Meal();
//        meal3.setMealId("120");
//        meal3.setMealName("Omelets");
//        meal3.setProtein("Vegetarian");
//        meal3.setServedWith("Rice");
//
//        Meal meal4 = new Meal();
//        meal4.setMealId("156");
//        meal4.setMealName("Tacos");
//        meal4.setProtein("Beef");
//        meal4.setServedWith("Potatoes");
//
//        ArrayList<Meal> emptyArrayList = new ArrayList<>();
//
//        when(mealDao.getTableSize()).thenReturn(77);
//        when(requests.getRequestedMeals()).thenReturn(emptyArrayList);
//        when(mealDao.getMeal(any())).thenReturn(meal1);
//        when(mealDao.getMeal(any())).thenReturn(meal2);
//        when(mealDao.getMeal(any())).thenReturn(meal3);
//        when(mealDao.getMeal(any())).thenReturn(meal4);
//
//        //WHEN
//        ArrayList<Meal> meals = createMealOptionsActivity.handleCreatePlanRequest(4);
//
//        //THEN
//        assertNotNull(meals);
//    }
//
//    @Test
//    public void handleCreatePlanRequest_exceedsMaxChicken_doesNotReturnExtraChickenMeal() {
//        //GIVEN
//        Meal meal1 = new Meal();
//        meal1.setMealId("123");
//        meal1.setMealName("Chipotle Bowls");
//        meal1.setProtein("Chicken");
//        meal1.setServedWith("Pasta");
//
//        Meal meal2 = new Meal();
//        meal2.setMealId("154");
//        meal2.setMealName("Meatball Subs");
//        meal2.setProtein("Chicken");
//        meal2.setServedWith("Pasta");
//
//        Meal meal3 = new Meal();
//        meal3.setMealId("120");
//        meal3.setMealName("Omelets");
//        meal3.setProtein("Chicken");
//        meal3.setServedWith("Rice");
//
//        Meal meal4 = new Meal();
//        meal4.setMealId("156");
//        meal4.setMealName("Tacos");
//        meal4.setProtein("Beef");
//        meal4.setServedWith("Potatoes");
//
//        ArrayList<Meal> emptyArrayList = new ArrayList<>();
//
//        when(mealDao.getTableSize()).thenReturn(77);
//        when(requests.getRequestedMeals()).thenReturn(emptyArrayList);
//        when(mealDao.getMeal(any())).thenReturn(meal1);
//        when(mealDao.getMeal(any())).thenReturn(meal2);
//        when(mealDao.getMeal(any())).thenReturn(meal3);
//        when(mealDao.getMeal(any())).thenReturn(meal4);
//
//        //WHEN
//        ArrayList<Meal> meals = createMealOptionsActivity.handleCreatePlanRequest(3);
//
//        //THEN
//        assertNotEquals(meals.get(0).getMealId(), meal3.getMealId());
//        assertNotEquals(meals.get(1).getMealId(), meal3.getMealId());
//        assertNotEquals(meals.get(2).getMealId(), meal3.getMealId());
//    }
//
//}
