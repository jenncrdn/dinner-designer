package main.java.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.dao.models.Meal;
import main.java.dependency.DaggerServiceComponent;
import main.java.dependency.ServiceComponent;

public class UpdateMealVotesActivityProvider implements RequestHandler<Meal, Meal> {
    public UpdateMealVotesActivityProvider() {
    }

    @Override
    public Meal handleRequest(Meal meal, Context context) {
        return getServiceComponent().provideUpdateMealVotesActivity().handleRequest(meal);
    }
    private ServiceComponent getServiceComponent() {
        return DaggerServiceComponent.create();
    }


}
