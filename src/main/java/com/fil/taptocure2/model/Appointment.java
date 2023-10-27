package com.fil.taptocure2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private long appointmentId;

    @Column(name = "date")
//    @NotEmpty(message = "Date for appointment is required")
//    @NotBlank(message = "Date for appointment is required")
//    @NotNull(message = "Date for appointment is required")
    private LocalDate date;

    @Column(name="health_problem")
//    @NotEmpty(message = "Description of health problem required")
//    @NotBlank(message = "Description of health problem required")
//    @NotNull(message = "Description of health problem required")
//    @Size(max=750,message = "Maximum length of description of health problem exceeded")
    private String healthProblem;

    @Column(name="appointment_status")
//    @NotEmpty(message = "Appointment status required")
//    @NotBlank(message = "Appointment status required")
//    @NotNull(message = "Appointment status required")
//    @Size(max=30,message = "Maximum length of appointment status exceeded")
    private String appointmentStatus;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//    @JsonBackReference
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JsonBackReference
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
