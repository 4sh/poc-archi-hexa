package com.izivia.tokensapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.izivia")
@EnableMongoRepositories("com.izivia")
public class TokensAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(TokensAppApplication.class, args);
  }

}
