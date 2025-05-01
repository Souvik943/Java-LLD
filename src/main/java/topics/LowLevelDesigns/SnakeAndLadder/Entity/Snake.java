package topics.LowLevelDesigns.SnakeAndLadder.Entity;

import java.util.HashMap;

public class Snake implements SnakeOrLadder{
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public HashMap<Integer, Integer> createSurprise() {
        HashMap<Integer, Integer> snakes = new HashMap<>();
        snakes.put(start, end);
        return snakes;
    }
}
