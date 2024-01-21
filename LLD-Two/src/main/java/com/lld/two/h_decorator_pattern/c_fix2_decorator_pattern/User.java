package com.lld.two.h_decorator_pattern.c_fix2_decorator_pattern;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private String name;
    private String email;
    private Long phone;
}
