package main.java.dynamo;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class DynamoDBProvider {
    private static final String dynamoDbEndpoint = "https://dynamodb.us-west-2.amazonaws.com";

    private static final String awsAccessKey = "AKIAV3IWUTHELU3JCVVV";

    private static final String awsSecretKey = "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";

    public static AmazonDynamoDB getAmazonDynamoDb() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamoDbEndpoint, "us-west-2"))
                .withCredentials(amazonDynamoDbCredentials())
                .build();
    }

    private static AWSCredentialsProvider amazonDynamoDbCredentials() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
    }
}
