//package main.java.lambda;
//
//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestHandler;
//import main.java.dao.models.User;
//import main.java.dependency.DaggerServiceComponent;
//import main.java.dependency.ServiceComponent;
//
//public class CreateNewUserActivityProvider implements RequestHandler<String, User> {
//    public CreateNewUserActivityProvider() {
//    }
//
//    @Override
//    public User handleRequest(String username, String password, Context context) {
//        return getServiceComponent().provideCreateNewUserActivity().handleRequest(username, password);
//    }
//    private ServiceComponent getServiceComponent() {
//        return DaggerServiceComponent.create();
//    }
//
//}
