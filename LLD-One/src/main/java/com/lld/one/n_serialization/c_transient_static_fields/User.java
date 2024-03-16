package com.lld.one.n_serialization.c_transient_static_fields;

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
    //private static final long serialVersionUID = 1000L; //comment while running in package c and uncomment in case of package d.
    @ToString.Include
    private static String species = "HUMAN";
    private int id;
    private String name;
    private String email;
    private transient String password; //uncomment in case of package c while comment in case of package d.
    //private String password; //comment in case of package c while uncomment in case of package d.
}
