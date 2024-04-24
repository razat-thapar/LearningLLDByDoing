package com.lld.one.o_java9_add_ons.a_try_with_resources;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
@Builder
@Getter
@ToString
public class User implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private String password;
}
