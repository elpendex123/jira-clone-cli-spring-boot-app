package com.example.jirausers;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByFullName(String fullName);

    public User findByUserId(String userId);

    public User findByEmail(String email);

    public List<User> findByJobTitle(String jobTitle);

    public List<User> findByDepartment(String department);
}
