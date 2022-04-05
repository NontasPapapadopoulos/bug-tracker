package com.example.bugtracker.repository;

import com.example.bugtracker.models.Bug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends CrudRepository <Bug, Long>  {

}
