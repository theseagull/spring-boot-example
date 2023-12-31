package com.its.buma.springbootexample;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.its.buma.springbootexample.customer.Customer;
import com.its.buma.springbootexample.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class SpringBootExampleApplication {
  public static void main(String[] args) {
//    ConfigurableApplicationContext cac =
            SpringApplication.run(SpringBootExampleApplication.class, args);
//    String[] beanDefinitionNames = cac.getBeanDefinitionNames();
//    for (String beanDefinitionName : beanDefinitionNames) {
//      System.out.println(beanDefinitionName);
//    }
  }
  @Bean
  CommandLineRunner runner(CustomerRepository customerRepository) {
    return args -> {
      var faker = new Faker();
      Random random = new Random();
      Name name = faker.name();
      String firstName = name.firstName();
      String lastName = name.lastName();
      Customer customer = new Customer(
              firstName +  " " + lastName,
              firstName.toLowerCase() + "." + lastName.toLowerCase() + "@amigoscode.com",
              random.nextInt(16, 99)
      );
      customerRepository.save(customer);
    };
  }
}
