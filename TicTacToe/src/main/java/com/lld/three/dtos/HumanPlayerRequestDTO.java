package com.lld.three.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class HumanPlayerRequestDTO {
    private String name ;
    private Character symbol ;

}
