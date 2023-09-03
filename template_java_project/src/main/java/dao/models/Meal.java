package main.java.dao.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

@DynamoDBTable(tableName = "Meals")
public class Meal {
    public static final String MEAL_NAME_INDEX = "MealNameIndex";
    private String mealId;
    private String mealName;
    private String protein;
    private String servedWith;
    private String imageURL;
    private int votes = 0;

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @DynamoDBHashKey(attributeName = "mealId")
    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    @DynamoDBIndexHashKey(globalSecondaryIndexName = MEAL_NAME_INDEX, attributeName = "mealName")
    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    @DynamoDBAttribute(attributeName = "protein")
    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    @DynamoDBAttribute(attributeName = "servedWith")
    public String getServedWith() {
        return servedWith;
    }

    public void setServedWith(String servedWith) {
        this.servedWith = servedWith;
    }

    @DynamoDBAttribute(attributeName = "imageURL")
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meal)) return false;
        Meal meal = (Meal) o;
        return Objects.equals(getMealId(), meal.getMealId()) && Objects.equals(getMealName(), meal.getMealName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMealId(), getMealName());
    }
}
