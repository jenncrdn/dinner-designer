package main.java.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.dao.models.Meal;
import main.java.dependency.DaggerServiceComponent;
import main.java.dependency.ServiceComponent;

import java.util.ArrayList;

public class CreateMealOptionsActivityProvider implements RequestHandler<Integer, ArrayList<Meal>> {
    public CreateMealOptionsActivityProvider() {
    }

    @Override
    public ArrayList<Meal> handleRequest(Integer input, Context context) {
        return getServiceComponent().provideCreateMealOptionsActivity().handleCreatePlanRequest(input);
    }
    private ServiceComponent getServiceComponent() {
        return DaggerServiceComponent.create();
    }


}
