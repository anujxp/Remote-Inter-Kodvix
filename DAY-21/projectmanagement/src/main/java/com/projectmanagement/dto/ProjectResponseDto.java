package com.projectmanagement.dto;

import com.projectmanagement.entity.ProjectStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectResponseDto {

    private Long id;
    private String projectName;
    private ProjectStatus projectStatus;
    private Double cost;
    private Double revenue;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}