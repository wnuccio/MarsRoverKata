public class Rover {
    private Point position;
    private Direction direction;
    private boolean obstacleEncountered;

    public Rover() {
        this.position = new Point(0, 0);
        this.direction = Direction.N;
        this.obstacleEncountered = false;
    }

    public void moveOnGrid(Grid grid) {
        Point newPosition = direction.getNextPosition(position);

        if (grid.hasObstacleAt(newPosition)) {
            this.obstacleEncountered = true;
            return;
        }

        this.position = grid.wrappedPoint(newPosition);
    }

    public void applyRotation(Rotation rotation) {
        direction = rotation.apply(direction);
    }

    public void writeOutput(Output output) {
        output.obstacleEncountered(obstacleEncountered);
        output.finalDirection(direction);
        position.writeOutput(output);
    }
}
