package com.lld.one.k_streams_and_lambdas.e_streams.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class GroupBy {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(User
                .builder()
                        .id(1)
                        .name("Razat")
                        .salary(123)
                .build());
        userList.add(User
                .builder()
                .id(2)
                .name("Anagh")
                .salary(123)
                .build());
        userList.add(User
                .builder()
                .id(3)
                .name("Merrick")
                .salary(456)
                .build());
        Map<Double, List<User>> map = userList.stream().collect(groupingBy(user->user.getSalary()));
        System.out.println(map);
    }
}
