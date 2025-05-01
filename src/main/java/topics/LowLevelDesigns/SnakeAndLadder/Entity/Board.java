package topics.LowLevelDesigns.SnakeAndLadder.Entity;

public class Board {
    private int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }
}
