package com.example.bugtracker.repository;

import com.example.bugtracker.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


//    List<User> findByUsername(String username);

    Optional<User> findByUsername(String username);
}
