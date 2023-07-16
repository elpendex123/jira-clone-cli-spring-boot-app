package com.example.jirausers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

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
        addUsers();
        findAllUsers();
        findUsersByFullName();
    }

    public void addUsers() {
        String userCsvFile = "/home/enrique/Documents/jira_clone_data/users2.csv";

        try (CSVReader csvReader = new CSVReader(new FileReader(userCsvFile))) {
            Object[] userLine;

            while ((userLine = csvReader.readNext()) != null) {
                System.out.println("user line: " + userLine);
                String userId = (String) userLine[0];
                String email = (String) userLine[1];
                String fullName = (String) userLine[2];
                String jobTitle = (String) userLine[3];
                String department = (String) userLine[4];
                String startDate = (String) userLine[5];
                Boolean active = Boolean.valueOf((String) userLine[6]);
                String team = (String) userLine[7];
                String phone = (String) userLine[8];
                repository.save(new User(userId, email, fullName, jobTitle, department,
                startDate, active, team, phone));
            }
        } catch (CsvValidationException CsvValidationException) {
            System.out.println("csv validation exception");
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("file not found exception");
        } catch (IOException ioException) {
            System.out.println("io exception");
        }
    }

    public void findAllUsers() {
        System.out.println("Users found with findAll():");
        for (User user : repository.findAll()) {
            System.out.println(user);
        }
    }

    public void findUsersByFullName() {
        System.out.println("User found with findByFullName('Jamal Cinnamond'):");
        System.out.println(repository.findByFullName("Jamal Cinnamond"));
    }

    // this is a mongo query to match partial full name (firstname) and also another field
    // test> db.user.find({ $and: [ {fullName: { $regex: "Paul "}}, { department: "Sales" } ] })
}
