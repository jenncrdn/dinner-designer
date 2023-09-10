package main.java.dependency;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Module;
import dagger.Provides;
import main.java.dynamo.DynamoDBProvider;

import javax.inject.Singleton;

/**
 * Provides DynamoDBMapper instance to DAO classes.
 */
@Module
public class DaoModule {

    @Provides
    @Singleton
    public DynamoDBMapper provideDynamoDBMapper() {
        DynamoDBMapper mapper = new DynamoDBMapper(DynamoDBProvider.getAmazonDynamoDb());
        System.out.println("Test 1 " + mapper);
        return mapper;
    }
}
