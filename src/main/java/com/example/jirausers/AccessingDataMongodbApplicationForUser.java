package com.example.jirausers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongodbApplicationForUser implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMongodbApplicationForUser.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        repository.save(new User("C08815", "jcinnamond0@ovh.net", "Jamal Cinnamond", "Desktop Support Technician",
                "Sales", "4/18/2010", true, "Challengers", "943-929-9038"));
        repository.save(new User("T85034", "gabrahim1@cisco.com", "Giffer Abrahim", "Assistant Media Planner",
                "Accounting", "8/31/2011", false, "Warriors", "352-886-7032"));

        System.out.println("Users found with findAll():");
        for (User user : repository.findAll()) {
            System.out.println(user);
        }

        System.out.println("User found with findByFullName('Jamal Cinnamond'):");
        System.out.println(repository.findByFullName("Jamal Cinnamond"));
    }
}
