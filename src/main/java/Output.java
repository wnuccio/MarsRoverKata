public class Output {
    private final boolean obstacleEncountered;
    private final Direction direction;
    int x;
    int y;

    public Output(boolean obstacleEncountered, Direction direction1) {
        this.obstacleEncountered = obstacleEncountered;
        this.direction = direction1;
    }

    public String asString() {
        String obstacles = obstacleEncountered ? "o:" : "";
        return String.format("%s%d:%d:%s", obstacles, x, y, direction.toString());
    }

    public void position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
