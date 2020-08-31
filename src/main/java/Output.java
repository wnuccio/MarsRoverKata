public class Output {
    private boolean obstacleEncountered;
    private Direction direction;
    private int x;
    private int y;

    public Output() {
    }

    void obstacleEncountered(boolean obstacleEncountered) {
        this.obstacleEncountered = obstacleEncountered;
    }

    void finalPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void finalDirection(Direction direction) {
        this.direction = direction;
    }

    public String asString() {
        String obstacleChar = obstacleEncountered ? "o:" : "";
        String directionChar = direction.name();
        return String.format("%s%d:%d:%s", obstacleChar, x, y, directionChar);
    }
}
