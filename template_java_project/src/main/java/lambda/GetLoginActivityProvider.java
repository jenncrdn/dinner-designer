//package main.java.lambda;
//
//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestHandler;
//import main.java.dao.models.User;
//import main.java.dependency.DaggerServiceComponent;
//import main.java.dependency.ServiceComponent;
//
//public class GetLoginActivityProvider implements RequestHandler<String, User> {
//
//    public GetLoginActivityProvider() {
//    }
//
//    @Override
//    public User handleRequest(String input, Context context) {
//        return getServiceComponent().provideGetLoginActivity(input, );
//    }
//
//    private ServiceComponent getServiceComponent() {
//        return DaggerServiceComponent.create();
//    }
//}
