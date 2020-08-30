public class MarsRover {
    private final Grid grid;
    private Point position;
    private Direction direction;
    private boolean obstacleEncountered;

    public MarsRover(Grid grid) {
        this.grid = grid;
        this.position = new Point(0, 0);

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
        Output output = new Output(obstacleEncountered, direction);
        position.addTo(output);
        return output.asString();
    }

    public void moveOn(NextPoint nextPoint) {
        Point newPosition = nextPoint.after(position);
        if (grid.hasObstacleAt(newPosition)) {
            this.obstacleEncountered = true;
            return;
        }

        this.position = grid.wrappedPoint(newPosition);
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
