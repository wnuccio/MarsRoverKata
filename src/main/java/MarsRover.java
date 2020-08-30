public class MarsRover {
    private final Grid grid;

    private int y;
    private int x;
    private Direction direction;
    private boolean obstacleEncountered;

    public MarsRover(Grid grid) {
        this.grid = grid;
        this.x = 0;
        this.y = 0;
        this.direction = Direction.N;
        this.obstacleEncountered = false;
    }

    public String execute(String commandString) {
        moveToFinalPosition(commandString);
        return buildOutputString();
    }

    private void moveToFinalPosition(String commandString) {
        for (char commandChar : commandString.toCharArray()) {
            Command command = Command.byChar(commandChar);
            command.apply(this);
        }
    }

    private String buildOutputString() {
        String obstacles = obstacleEncountered ? "o:" : "";
        return String.format("%s%d:%d:%s", obstacles, x, y, direction.toString());
    }

    private void moveOn(int x1, int y1) {
        if (grid.hasObstacleAt(x1, y1)) {
            this.obstacleEncountered = true;
            return;
        }

        x = grid.wrappedCoordinate(x1);
        y = grid.wrappedCoordinate(y1);
    }

    void moveRight() {
        moveOn(x+1, y);
    }

    void moveLeft() {
        x = grid.wrappedCoordinate(x - 1);
    }

    void moveUp() {
        moveOn(x, y+1);
    }

    void moveDown() {
        y = grid.wrappedCoordinate(y - 1);
}

    void advance() {
        direction.advance(this);
    }

    void rotateLeft() {
        direction = direction.rotateLeft();
    }

    void rotateRight() {
        direction = direction.rotateRight();
    }
}
