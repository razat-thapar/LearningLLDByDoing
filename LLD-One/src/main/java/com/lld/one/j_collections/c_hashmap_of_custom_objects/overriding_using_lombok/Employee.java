package com.lld.one.j_collections.c_hashmap_of_custom_objects.overriding_using_lombok;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"name"} , of = {"id"})
class Employee {
    private int id;
    private String name;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Employee employee = (Employee) o;
//
//        return id == employee.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return id;
//    }
}
