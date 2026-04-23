package com.projectmanagement.repository;

import com.projectmanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    // Fetch all projects sorted by projectName ascending
    List<Project> findAllByOrderByProjectNameAsc();

    // Check if a project with the same name already exists (for duplicate validation)
    Optional<Project> findByProjectName(String projectName);

    // Check if another project (excluding current id) has the same name (for update validation)
    Optional<Project> findByProjectNameAndIdNot(String projectName, Long id);

//    @Query("SELECT p FROM Project p ORDER BY p.projectName ASC")
//    List<Project> findAllSortedByName();

//    @Query("SELECT p FROM Project p ORDER BY p.projectName ASC")
//    List<Project> findAllSortedByName();
}