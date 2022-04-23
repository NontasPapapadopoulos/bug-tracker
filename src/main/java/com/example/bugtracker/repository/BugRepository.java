package com.example.bugtracker.repository;

import com.example.bugtracker.models.Bug;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface BugRepository extends CrudRepository <Bug, Long>  {




    @Query(value="SELECT sum(case when bug_status = 'UNRESOLVED' then 1 else 0 end) as unresolved from bug" ,nativeQuery=true )
    public Long getUnresolvedBugs();

    @Query(value="SELECT sum(case when bug_status = 'RESOLVED' then 1 else 0 end) as unresolved from bug" ,nativeQuery=true)
    public Long getResolvedBugs();

    @Query(value="SELECT sum(case when bug_status = 'UNDER_Testing' then 1 else 0 end) as unresolved from bug" ,nativeQuery=true)
    public Long getUnderTestingBugs();


    @Query(value="SELECT * from bug where project_id = ?1" ,nativeQuery=true )
    public List<Bug> getBugsByProject(Long projectId);

    @Query(value="SELECT * from bug where project_id = (select project_id from project where name = 1?)" ,nativeQuery=true )
    public List<Bug> getBugsByProjectName(String projectName);



    @Query(value="SELECT * from bug where project_id = ?1 and user_id= ?2" ,nativeQuery=true )
    public List<Bug> getBugsByProjectAndUser(Long projectId, Long userId);

}
