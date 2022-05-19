package com.izivia.mobility.core.organizations.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.izivia")
@EnableMongoRepositories("com.izivia")
public class OrganizationsApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrganizationsApplication.class, args);
  }

}
