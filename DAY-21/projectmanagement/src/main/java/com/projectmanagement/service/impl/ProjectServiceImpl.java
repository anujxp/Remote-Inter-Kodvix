package com.projectmanagement.service.impl;

import com.projectmanagement.dto.ProjectRequestDto;
import com.projectmanagement.dto.ProjectResponseDto;
import com.projectmanagement.entity.Project;
import com.projectmanagement.exception.BadRequestException;
import com.projectmanagement.exception.DuplicateResourceException;
import com.projectmanagement.exception.ResourceNotFoundException;
import com.projectmanagement.repository.ProjectRepository;
import com.projectmanagement.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    // ==========================================
    // CREATE PROJECT
    // ==========================================
    @Override
    @Transactional
    public ProjectResponseDto createProject(ProjectRequestDto requestDto) {

        // Check for duplicate project name
        projectRepository.findByProjectName(requestDto.getProjectName())
                .ifPresent(existing -> {
                    throw new DuplicateResourceException(
                            "Project", "projectName", requestDto.getProjectName()
                    );
                });

        Project project = mapToEntity(requestDto);
        Project savedProject = projectRepository.save(project);

        return mapToResponseDto(savedProject);
    }

    // ==========================================
    // GET ALL PROJECTS
    // ==========================================
    @Override
    @Transactional(readOnly = true)
    public List<ProjectResponseDto> getAllProjects() {

        return projectRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    // ==========================================
    // GET PROJECT BY ID
    // ==========================================
    @Override
    @Transactional(readOnly = true)
    public ProjectResponseDto getProjectById(Long id) {

        Project project = findProjectByIdOrThrow(id);
        return mapToResponseDto(project);
    }

    // ==========================================
    // UPDATE PROJECT
    // ==========================================
    @Override
    @Transactional
    public ProjectResponseDto updateProject(Long id, ProjectRequestDto requestDto) {

        Project existingProject = findProjectByIdOrThrow(id);

        // Check if another project (not this one) already has the same name
        projectRepository.findByProjectNameAndIdNot(requestDto.getProjectName(), id)
                .ifPresent(duplicate -> {
                    throw new DuplicateResourceException(
                            "Project", "projectName", requestDto.getProjectName()
                    );
                });

        existingProject.setProjectName(requestDto.getProjectName());
        existingProject.setProjectStatus(requestDto.getProjectStatus());
        existingProject.setCost(requestDto.getCost());
        existingProject.setRevenue(requestDto.getRevenue());

        Project updatedProject = projectRepository.save(existingProject);

        return mapToResponseDto(updatedProject);
    }

    // ==========================================
    // DELETE PROJECT
    // ==========================================
    @Override
    @Transactional
    public void deleteProject(Long id) {

        Project project = findProjectByIdOrThrow(id);
        projectRepository.delete(project);
    }

    // ==========================================
    // BULK INSERT PROJECTS
    // ==========================================
    @Override
    @Transactional
    public List<ProjectResponseDto> saveProjectsInBulk(List<ProjectRequestDto> requestDtoList) {

        if (requestDtoList == null || requestDtoList.isEmpty()) {
            throw new BadRequestException("Project list must not be empty for bulk insert.");
        }

        List<Project> projects = requestDtoList.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());

        List<Project> savedProjects = projectRepository.saveAll(projects);

        return savedProjects.stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    // ==========================================
    // PAGINATED PROJECTS
    // ==========================================
    @Override
    @Transactional(readOnly = true)
    public Page<ProjectResponseDto> getPaginatedProjects(int page, int size) {

        if (page < 0) {
            throw new BadRequestException("Page index must not be less than zero.");
        }
        if (size <= 0) {
            throw new BadRequestException("Page size must be greater than zero.");
        }

        Pageable pageable = PageRequest.of(page, size);
        Page<Project> projectPage = projectRepository.findAll(pageable);

        return projectPage.map(this::mapToResponseDto);
    }

    // ==========================================
    // SORTED BY PROJECT NAME (ASCENDING)
    // ==========================================
    @Override
    @Transactional(readOnly = true)
    public List<ProjectResponseDto> getAllProjectsSortedByName() {

        return projectRepository.findAllByOrderByProjectNameAsc()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    // ==========================================
    // PRIVATE HELPER METHODS
    // ==========================================

    private Project findProjectByIdOrThrow(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", id));
    }

    private Project mapToEntity(ProjectRequestDto dto) {
        return Project.builder()
                .projectName(dto.getProjectName())
                .projectStatus(dto.getProjectStatus())
                .cost(dto.getCost())
                .revenue(dto.getRevenue())
                .build();
    }

    private ProjectResponseDto mapToResponseDto(Project project) {
        return ProjectResponseDto.builder()
                .id(project.getId())
                .projectName(project.getProjectName())
                .projectStatus(project.getProjectStatus())
                .cost(project.getCost())
                .revenue(project.getRevenue())
                .createdAt(project.getCreatedAt())
                .updatedAt(project.getUpdatedAt())
                .build();
    }
}