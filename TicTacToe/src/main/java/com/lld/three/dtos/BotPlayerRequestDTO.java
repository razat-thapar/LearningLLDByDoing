package com.lld.three.dtos;

import com.lld.three.models.enums.DifficultyLevel;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BotPlayerRequestDTO {
    private String name;
    private Character symbol;
    private DifficultyLevel difficultyLevel;
}
