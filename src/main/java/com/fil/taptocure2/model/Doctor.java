package com.fil.taptocure2.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long doctorId;

    @Column(name = "first_name")
//    @NotEmpty(message = "Doctor firstName required")
//    @NotBlank(message = "Doctor firstName required")
//    @NotNull(message = "Doctor firstName required")
        private String firstName;

    @Column(name = "last_name")
//    @NotEmpty(message = "Doctor lastName required")
//    @NotBlank(message = "Doctor lastName required")
//    @NotNull(message = "Doctor lastName required")
    private  String lastName;

    @Column(name = "doctor_email")
//    @Email(message = "Not a valid Email")
//    @NotEmpty(message = "Doctor doctorEmail required")
//    @NotBlank(message = "Doctor doctorEmail required")
//    @NotNull(message = "Doctor doctorEmail required")
    private String doctorEmail;

    @Column(name = "password")
//    @NotEmpty(message = "Doctor password required")
//    @NotBlank(message = "Doctor password required")
//    @NotNull(message = "Doctor password required")
    private String password;

    @Column(name = "shift_start_time")
    private String shiftStartTime;

    @Column(name = "shift_end_time")
    private String shiftStartEnd;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
//    @JsonManagedReference
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY,cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//    @JsonManagedReference
    private List<MedicalRecord> medicalRecords;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
//    @JsonBackReference
    private Department department;

}
