package com.example.bugtracker.repository;

import com.example.bugtracker.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {



}
