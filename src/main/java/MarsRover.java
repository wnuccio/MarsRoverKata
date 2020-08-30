public class MarsRover {
    private final Grid grid;

    private int y;
    private int x;
    private Direction direction;

    public MarsRover(Grid grid) {
        this.grid = grid;
        this.x = 0;
        this.y = 0;
        this.direction = Direction.N;
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
        return String.format("%d:%d:%s", x, y, direction.toString());
    }

    void moveRight() {
        x = grid.correctCoordinateByWrapping(x + 1);
    }

    void moveLeft() {
        x = grid.correctCoordinateByWrapping(x - 1);
    }

    void moveUp() {
        y = grid.correctCoordinateByWrapping(y + 1);
    }

    void moveDown() {
        y = grid.correctCoordinateByWrapping(y - 1);
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
