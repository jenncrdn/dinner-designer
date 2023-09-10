package main.java.dependency;

import dagger.Component;
import main.java.activity.*;

import javax.inject.Singleton;

/**
 * Declares the dependency roots that Dagger will provide.
 */
@Singleton
@Component(modules = DaoModule.class)
public interface ServiceComponent {

    GetMealPlanActivity provideGetMealPlanActivity();
    GetAllMealsActivity provideGetAllMealsActivity();
    CreateRequestActivity provideCreateRequestActivity();
    CreateMealOptionsActivity provideCreateMealOptionsActivity();
    UpdateMealOptionsActivity provideUpdateMealOptionsActivity();
    GetMealOptionsActivity provideGetMealOptionsActivity();
    UpdateMealVotesActivity provideUpdateMealVotesActivity();
    CreateNewUserActivity provideCreateNewUserActivity();
    GetLoginActivity provideGetLoginActivity();
}
