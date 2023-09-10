package main.java.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.dao.models.Meal;
import main.java.dependency.DaggerServiceComponent;
import main.java.dependency.ServiceComponent;

import java.util.ArrayList;

public class GetAllMealsActivityProvider implements RequestHandler<Void , ArrayList<Meal>> {
    public GetAllMealsActivityProvider() {
    }

    @Override
    public ArrayList<Meal> handleRequest(Void input, Context context) {
        return getServiceComponent().provideGetAllMealsActivity().handleRequest();
    }
    private ServiceComponent getServiceComponent() {
        return DaggerServiceComponent.create();
    }
}
