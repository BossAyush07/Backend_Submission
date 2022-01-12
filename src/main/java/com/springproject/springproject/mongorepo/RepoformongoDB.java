package com.springproject.springproject.mongorepo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springproject.springproject.entities.Users;

public interface RepoformongoDB extends MongoRepository<Users, String>{

}
