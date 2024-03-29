package com.palette.back_end.util.s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {

  @Value("${spring.cloud.config.server.awss3.access-key}")
  private String ACCESS_KEY;

  @Value("${spring.cloud.config.server.awss3.secret-key}")
  private String SECRET_KEY;

  @Value("${spring.cloud.config.server.awss3.region}")
  private String REGION;

  @Bean
  public AmazonS3 amazonS3Client() {
    AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);

    return AmazonS3ClientBuilder.standard()
        .withRegion(REGION)
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .build();
  }
}
