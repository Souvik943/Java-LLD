package topics.LowLevelDesigns.SnakeAndLadder.Utility;

import topics.LowLevelDesigns.SnakeAndLadder.Entity.Player;

import java.util.HashMap;

public class Util {
    public static int calculatePlayerFinalPosition(HashMap<Integer, Integer> snakeHashMap, HashMap<Integer, Integer> ladderHashMap, Player player, int diceValue, int boardSize) {
        int playerFinalPosition = player.getPlayPosition() + diceValue;
        if(playerFinalPosition > boardSize) {
            playerFinalPosition = player.getPlayPosition();
        } else {
            if(snakeHashMap.containsKey(playerFinalPosition)) {
                playerFinalPosition = snakeHashMap.get(playerFinalPosition);
                System.out.println(player.getPlayerName() + " got bit by a snake and moved from : " + player.getPlayPosition() + " to : " + playerFinalPosition);
            } else if(ladderHashMap.containsKey(playerFinalPosition)){
                playerFinalPosition = ladderHashMap.get(playerFinalPosition);
                System.out.println(player.getPlayerName() + " got a ladder and moved from : " + player.getPlayPosition() + " to : " + playerFinalPosition);
            } else {
                System.out.println(player.getPlayerName() + " got : " + diceValue + " moved from : " + player.getPlayPosition() + " to : " + playerFinalPosition);
            }
        }
        return playerFinalPosition;
    }

}
