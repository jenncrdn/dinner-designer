package main.java.dependency;

import dagger.Component;
import main.java.activity.CreateMealOptionsActivity;
import main.java.activity.CreateRequestActivity;
import main.java.activity.UpdateMealOptionsActivity;

import javax.inject.Singleton;

/**
 * Declares the dependency roots that Dagger will provide.
 */
@Singleton
@Component(modules = DaoModule.class)
public interface ServiceComponent {

}
