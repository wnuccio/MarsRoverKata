public class MarsRover {
    private final Grid grid;
    public Point position;
    public Direction direction;
    public boolean obstacleEncountered;

    public MarsRover(Grid grid) {
        this.grid = grid;
        this.position = new Point(0, 0);

        this.direction = Direction.N;
        this.obstacleEncountered = false;
    }

    public String execute(String commandString) {
        CommandString commands = new CommandString(commandString);
        Output output = commands.execute(this);
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
