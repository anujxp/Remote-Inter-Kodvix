package com.projectmanagement.dto;

import com.projectmanagement.entity.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectRequestDto {

    @NotBlank(message = "Project name must not be blank")
    @Size(min = 3, max = 100, message = "Project name must be between 3 and 100 characters")
    private String projectName;

    @NotNull(message = "Project status must not be null")
    private ProjectStatus projectStatus;

    @NotNull(message = "Cost must not be null")
    @Positive(message = "Cost must be a positive value")
    private Double cost;

    @NotNull(message = "Revenue must not be null")
    @Positive(message = "Revenue must be a positive value")
    private Double revenue;
}