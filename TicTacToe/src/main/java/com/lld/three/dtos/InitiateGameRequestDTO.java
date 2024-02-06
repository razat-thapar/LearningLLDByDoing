package com.lld.three.dtos;

import com.lld.three.models.Player;
import com.lld.three.models.strategies.winning.WinningStrategy;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Builder
@Getter
public class InitiateGameRequestDTO {
    private int size;
    private List<Player> playerList;
    private List<WinningStrategy> winningStrategyList;
}
