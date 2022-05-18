package com.izivia.mobility.core.organizations.app;

import com.izivia.mobility.core.organizations.api.data.ElectricalMobilityApiData;
import com.izivia.mobility.core.organizations.api.data.PostalAddressApiData;
import com.izivia.mobility.core.organizations.api.service.ElectricalMobilityServiceApi;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.izivia")
@EnableMongoRepositories("com.izivia")
public class OrganizationsApplication implements CommandLineRunner {
  @Autowired
  private ElectricalMobilityServiceApi electricalMobilityServiceApi;

  public static void main(String[] args) {
    SpringApplication.run(OrganizationsApplication.class, args);
  }


  @Override
  public void run(String... args) throws Exception {

    List<ElectricalMobilityApiData> electricalMobilityApiDatas = electricalMobilityServiceApi.findAll();
    electricalMobilityApiDatas.forEach(System.out::println);
    System.out.println("Size "+electricalMobilityApiDatas.size());
    System.out.println("Find one Data");
    System.out.println( "Result :"+electricalMobilityServiceApi.findUnique("627a582a5ef5767e6f908299"));
    System.out.println("Adding one :");
    Optional<ElectricalMobilityApiData> createElectricalMobility = electricalMobilityServiceApi.create(
        ElectricalMobilityApiData.builder()
            .id("888888")
            .name("My custom Electrical mobility")
            .tin("tin")
            .postalAddress(PostalAddressApiData.builder()
                .country("Defense")
                .zipCode("92000")
                .city("City")
                .street("Street").build())
            .build());
    System.out.println(" createElectricalMobility : "+createElectricalMobility.get());

    List<ElectricalMobilityApiData> electricalMobilityApiDatas2 = electricalMobilityServiceApi.findAll();
    electricalMobilityApiDatas2.forEach(System.out::println);
    System.out.println("Size "+electricalMobilityApiDatas2.size());

  }
}
