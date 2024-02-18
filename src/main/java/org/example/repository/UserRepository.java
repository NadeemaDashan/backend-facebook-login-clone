package org.example.repository;

import org.example.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends MongoRepository<User,String> {

    boolean existsByUsername(String username);

    User findByUsername(String username);

}
