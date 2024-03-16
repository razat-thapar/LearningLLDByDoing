package com.lld.one.n_serialization.b_fix1_implementing_serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
public class User implements Serializable {
    private int id;
    private String name;
    private String email;
    private String password;
}
