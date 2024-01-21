package com.lld.two.h_decorator_pattern.a_problem;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private String name;
    private String email;
    private Long phone;
}
