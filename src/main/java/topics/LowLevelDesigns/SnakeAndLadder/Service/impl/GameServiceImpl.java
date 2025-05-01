package topics.LowLevelDesigns.SnakeAndLadder.Service.impl;

import topics.LowLevelDesigns.SnakeAndLadder.Entity.Board;
import topics.LowLevelDesigns.SnakeAndLadder.Entity.Dice;
import topics.LowLevelDesigns.SnakeAndLadder.Entity.Player;
import topics.LowLevelDesigns.SnakeAndLadder.Service.GameService;
import topics.LowLevelDesigns.SnakeAndLadder.Utility.Util;

import java.util.HashMap;
import java.util.List;

public class GameServiceImpl implements GameService {

    List<Player> playersList;
    HashMap<Integer, Integer> snakeHashMap;
    HashMap<Integer, Integer> ladderHashMap;
    Dice dice;
    Board board;

    public GameServiceImpl(List<Player> playersList, HashMap<Integer, Integer> snakeHashMap, HashMap<Integer, Integer> ladderHashMap, Dice dice, Board board) {
        this.playersList = playersList;
        this.snakeHashMap = snakeHashMap;
        this.ladderHashMap = ladderHashMap;
        this.dice = dice;
        this.board = board;
    }

    @Override
    public void playGame() {
        System.out.println("Game starts ...");
        boolean gameWon = false;
        while(!gameWon) {
            for(Player player : playersList) {
                int diceValue = dice.rollDice(dice.getDiceSize());
                int playerFinalPosition = Util.calculatePlayerFinalPosition(snakeHashMap, ladderHashMap, player, diceValue, board.getBoardSize());
                if(player.getPlayPosition() != playerFinalPosition) {
                    player.setPlayPosition(playerFinalPosition);
                }
                if(player.getPlayPosition() == board.getBoardSize()) {
                    System.out.println(player.getPlayerName() + " won the game ...");
                    gameWon = true;
                    break;
                }
            }
        }
    }
}
