package com.lld.one.n_serialization.a_motivation;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
}
