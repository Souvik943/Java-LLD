package topics.LowLevelDesigns.SnakeAndLadder.Entity;

import java.util.Random;

public class Dice {
    private final Random random = new Random();
    private int diceSize;

    public Dice(int diceSize) {
        this.diceSize = diceSize;
    }

    public int getDiceSize() {
        return diceSize;
    }

    public void setDiceSize(int diceSize) {
        this.diceSize = diceSize;
    }

    public int rollDice(int diceSize) {
        return random.nextInt(diceSize) + 1;
    }
}
