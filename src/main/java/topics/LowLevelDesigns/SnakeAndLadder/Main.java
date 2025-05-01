package topics.LowLevelDesigns.SnakeAndLadder;


import topics.LowLevelDesigns.SnakeAndLadder.Entity.Board;
import topics.LowLevelDesigns.SnakeAndLadder.Entity.Dice;
import topics.LowLevelDesigns.SnakeAndLadder.Entity.Player;
import topics.LowLevelDesigns.SnakeAndLadder.Service.GameService;
import topics.LowLevelDesigns.SnakeAndLadder.Service.impl.GameServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Building the Snakes
        HashMap<Integer, Integer> snakeHashMap = new HashMap<>();
        int numberOfSnakes = sc.nextInt();
        for(int i=0; i<numberOfSnakes; i++) {
            snakeHashMap.put(sc.nextInt(), sc.nextInt());
        }

        //Building the Ladders
        HashMap<Integer, Integer> ladderHashMap = new HashMap<>();
        int numberOfLadder = sc.nextInt();
        for(int i = 0; i< numberOfLadder; i++) {
            ladderHashMap.put(sc.nextInt(), sc.nextInt());
        }

        //Initializing the players
        int numberOfPlayers = sc.nextInt();
        sc.nextLine();
        ArrayList<Player> playerList = new ArrayList<>();
        for(int i=0; i<numberOfPlayers; i++) {
            playerList.add(new Player(sc.nextLine()));
        }

        //Initializing the dice
        int diceSize = sc.nextInt();
        Dice dice = new Dice(diceSize);

        //Initializing the board
        int boardSize = sc.nextInt();
        Board board = new Board(boardSize);

        GameService gameService = new GameServiceImpl(playerList, snakeHashMap, ladderHashMap, dice, board);
        gameService.playGame();
    }
}
