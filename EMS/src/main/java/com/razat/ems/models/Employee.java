package com.razat.ems.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Date doj;
    @Column
    private double salary;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Department department;
}
