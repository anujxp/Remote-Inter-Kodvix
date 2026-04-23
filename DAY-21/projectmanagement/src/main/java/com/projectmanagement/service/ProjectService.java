package com.projectmanagement.service;

import com.projectmanagement.dto.ProjectRequestDto;
import com.projectmanagement.dto.ProjectResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProjectService {

    ProjectResponseDto createProject(ProjectRequestDto requestDto);

    List<ProjectResponseDto> getAllProjects();

    ProjectResponseDto getProjectById(Long id);

    ProjectResponseDto updateProject(Long id, ProjectRequestDto requestDto);

    void deleteProject(Long id);

    List<ProjectResponseDto> saveProjectsInBulk(List<ProjectRequestDto> requestDtoList);

    Page<ProjectResponseDto> getPaginatedProjects(int page, int size);

    List<ProjectResponseDto> getAllProjectsSortedByName();
}