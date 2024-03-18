package com.lld.one.n_serialization.g_effect_of_inheritance.b_super_dont_implements_serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
public class Employee {
    protected Integer id;
    protected String name;
    protected String email;
    protected Double salary;
    protected Integer managerId;
}
