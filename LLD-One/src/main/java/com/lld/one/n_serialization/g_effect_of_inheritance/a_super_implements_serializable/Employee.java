package com.lld.one.n_serialization.g_effect_of_inheritance.a_super_implements_serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@ToString
public class Employee implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private Double salary;
    private Integer managerId;
}
