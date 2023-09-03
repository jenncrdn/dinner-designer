package main.java.dependency;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Provides DynamoDBMapper instance to DAO classes.
 */
@Module
public class DaoModule {

    private String dynamoDbEndpoint = "https://dynamodb.us-west-2.amazonaws.com";

    private String awsAccessKey = "AKIAV3IWUTHELU3JCVVV";

    private String awsSecretKey = "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";

    /**
     * Creates and returns a DynamoDBMapper instance for the appropriate region.
     * @return a DynamoDBMapper
     */
    @Singleton
    @Provides
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(amazonDynamoDb());
    }

    private AmazonDynamoDB amazonDynamoDb() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamoDbEndpoint, "us-west-2"))
                .withCredentials(amazonDynamoDbCredentials())
                .build();
    }

    private AWSCredentialsProvider amazonDynamoDbCredentials() {
        System.out.println(awsAccessKey);
        System.out.println(awsSecretKey);
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
    }
}
