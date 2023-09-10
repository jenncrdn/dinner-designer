package main.java.dynamo;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DynamoDBProvider {
    private static final String dynamoDbEndpoint = "https://dynamodb.us-west-2.amazonaws.com";

    private static final String awsAccessKey = "AKIAV3IWUTHELU3JCVVV";

    private static final String awsSecretKey = "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";

    /**
     * Creates and returns a DynamoDBMapper instance for the appropriate region.
     * @return a DynamoDBMapper
     */
    public static DynamoDBMapper getDynamoDBMapper() {
        System.out.println("Test 3");
        return new DynamoDBMapper(getAmazonDynamoDb());
    }

    public static AmazonDynamoDB getAmazonDynamoDb() {
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamoDbEndpoint, "us-west-2"))
                .withCredentials(amazonDynamoDbCredentials())
                .build();
        System.out.println("Test 2 " + amazonDynamoDB);
        return amazonDynamoDB;
    }

    private static AWSCredentialsProvider amazonDynamoDbCredentials() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
    }
}
