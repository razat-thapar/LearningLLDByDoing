package com.lld.three.services;

import com.lld.three.models.Cell;
import com.lld.three.models.Game;
import com.lld.three.models.Move;
import com.lld.three.models.Player;
import com.lld.three.models.enums.PlayerType;

import java.util.Scanner;

public class CommandLineService {
    static boolean askIfNeedToUndoLastMove(Game game, Move recentMove) {
        //check if it's human player.
        Cell currentCell = game.getBoard().getCells().get(recentMove.getRow()).get(recentMove.getCol());
        Player player = currentCell.getPlayer();
        Scanner sc = new Scanner(System.in);
        if (player.getUser().getPlayerType() == PlayerType.HUMAN) {
            //display board
            System.out.println(game.getBoard().displayBoard());
            System.out.println("Do you want to undo the last move ? y or n");
            char ch = sc.next().charAt(0);
            if (ch == 'y') {
                GameService.undoLastMove(game, recentMove);
                return true;
            }
        }
        return false;
    }

}
