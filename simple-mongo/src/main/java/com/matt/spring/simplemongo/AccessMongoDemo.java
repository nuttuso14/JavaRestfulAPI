package com.matt.spring.simplemongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccessMongoDemo {

    @Autowired
    private CustomerRepository repository;


    @Bean
    public CommandLineRunner runAccessMongo() {
        return args -> {
            repository.save(new Customer("Micheal", "Owen"));

            // fetch all customers
            System.out.println("Customers found with findAll():");
            System.out.println("-------------------------------");
            for (Customer customer : repository.findAll()) {
                System.out.println(customer);
            }
            System.out.println();

            // fetch an individual customer
/*        System.out.println("Customer found with findByFirstName('Owen'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Satoshi"));*/

            System.out.println("Customers found with findByLastName('Owen'):");
            System.out.println("--------------------------------");
            for (Customer customer : repository.findByLastName("Owen")) {
                System.out.println(customer);
            }
        };
    }


/*    @Override
    public void run(String... args) throws Exception {
        //repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Micheal", "Owen"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
*//*        System.out.println("Customer found with findByFirstName('Owen'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Satoshi"));*//*

        System.out.println("Customers found with findByLastName('Owen'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Owen")) {
            System.out.println(customer);
        }

    }*/
}
