package main.java.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.dao.models.Meal;
import main.java.dependency.DaggerServiceComponent;
import main.java.dependency.ServiceComponent;

import java.util.ArrayList;

public class GetMealOptionsActivityProvider implements RequestHandler<Void, ArrayList<Meal>> {
    public GetMealOptionsActivityProvider() {
    }

    @Override
    public ArrayList<Meal> handleRequest(Void input, Context context) {
        return getServiceComponent().provideGetMealOptionsActivity().handleGetOptionsRequest();
    }

    private ServiceComponent getServiceComponent() {
        return DaggerServiceComponent.create();
    }

}
