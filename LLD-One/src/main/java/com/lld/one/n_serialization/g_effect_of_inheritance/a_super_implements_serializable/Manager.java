package com.lld.one.n_serialization.g_effect_of_inheritance.a_super_implements_serializable;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
public class Manager extends Employee{
    private ManagerLevel managerLevel;
}
