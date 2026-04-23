package com.projectmanagement.controller;

import com.projectmanagement.dto.ProjectRequestDto;
import com.projectmanagement.dto.ProjectResponseDto;
import com.projectmanagement.response.ApiResponse;
import com.projectmanagement.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    // ==========================================
    // POST /api/projects — Create Project
    // ==========================================
    @PostMapping
    public ResponseEntity<ApiResponse<ProjectResponseDto>> createProject(
            @Valid @RequestBody ProjectRequestDto requestDto) {

        ProjectResponseDto responseDto = projectService.createProject(requestDto);

        return new ResponseEntity<>(
                ApiResponse.success("Project created successfully.", responseDto),
                HttpStatus.CREATED
        );
    }

    // ==========================================
    // GET /api/projects — Get All Projects
    // ==========================================
    @GetMapping
    public ResponseEntity<ApiResponse<List<ProjectResponseDto>>> getAllProjects() {

        List<ProjectResponseDto> projects = projectService.getAllProjects();

        return ResponseEntity.ok(
                ApiResponse.success("Projects fetched successfully.", projects)
        );
    }

    // ==========================================
    // GET /api/projects/{id} — Get Project By ID
    // ==========================================
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProjectResponseDto>> getProjectById(
            @PathVariable Long id) {

        ProjectResponseDto responseDto = projectService.getProjectById(id);

        return ResponseEntity.ok(
                ApiResponse.success("Project fetched successfully.", responseDto)
        );
    }

    // ==========================================
    // PUT /api/projects/{id} — Update Project
    // ==========================================
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProjectResponseDto>> updateProject(
            @PathVariable Long id,
            @Valid @RequestBody ProjectRequestDto requestDto) {

        ProjectResponseDto responseDto = projectService.updateProject(id, requestDto);

        return ResponseEntity.ok(
                ApiResponse.success("Project updated successfully.", responseDto)
        );
    }

    // ==========================================
    // DELETE /api/projects/{id} — Delete Project
    // ==========================================
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteProject(
            @PathVariable Long id) {

        projectService.deleteProject(id);

        return ResponseEntity.ok(
                ApiResponse.success("Project deleted successfully.", "Deleted project with ID: " + id)
        );
    }

    // ==========================================
    // POST /api/projects/bulk — Bulk Insert
    // ==========================================
    @PostMapping("/bulk")
    public ResponseEntity<ApiResponse<List<ProjectResponseDto>>> saveProjectsInBulk(
            @Valid @RequestBody List<@Valid ProjectRequestDto> requestDtoList) {

        List<ProjectResponseDto> savedProjects = projectService.saveProjectsInBulk(requestDtoList);

        return new ResponseEntity<>(
                ApiResponse.success(
                        savedProjects.size() + " projects saved successfully in bulk.",
                        savedProjects
                ),
                HttpStatus.CREATED
        );
    }

    // ==========================================
    // GET /api/projects/paginated — Paginated Projects
    // ==========================================
    @GetMapping("/paginated")
    public ResponseEntity<ApiResponse<Page<ProjectResponseDto>>> getPaginatedProjects(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<ProjectResponseDto> paginatedProjects = projectService.getPaginatedProjects(page, size);

        return ResponseEntity.ok(
                ApiResponse.success("Paginated projects fetched successfully.", paginatedProjects)
        );
    }

    // ==========================================
    // GET /api/projects/sorted — Sorted by Name ASC
    // ==========================================
    @GetMapping("/sorted")
    public ResponseEntity<ApiResponse<List<ProjectResponseDto>>> getAllProjectsSortedByName() {

        List<ProjectResponseDto> sortedProjects = projectService.getAllProjectsSortedByName();

        return ResponseEntity.ok(
                ApiResponse.success("Projects fetched and sorted by name (ascending).", sortedProjects)
        );
    }
}