package com.example.bugtracker.repository;

import com.example.bugtracker.models.Comment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long > {

    @Query(value = "SELECT * from comment where bug_id =?1", nativeQuery = true)
    List<Comment> findAllCommentsByBugId(Long bugId);
}
