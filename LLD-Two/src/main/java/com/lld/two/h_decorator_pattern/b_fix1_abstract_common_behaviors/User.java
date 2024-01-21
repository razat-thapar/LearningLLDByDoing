package com.lld.two.h_decorator_pattern.b_fix1_abstract_common_behaviors;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private String name;
    private String email;
    private Long phone;
}
