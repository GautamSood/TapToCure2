package com.fil.taptocure2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private long departmentId;

    @Column(name = "department_name")
//    @NotBlank(message = "department name is required")
//    @NotNull(message = "department name is required")
//    @NotEmpty(message = "department name is required")
    private String departmentName;

    @Column(name = "description")
//    @NotBlank(message = "description is required")
//    @NotNull(message = "description is required")
//    @NotEmpty(message = "description is required")
    private String description;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
    private List<Doctor> doctors ;
}
