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

    void rotateLeft() {
        direction = direction.rotateLeft();
    }

    void rotateRight() {
        direction = direction.rotateRight();
    }

    public Output produceOutput() {
        Output output = new Output(obstacleEncountered, direction);
        position.addTo(output);
        return output;
    }


}
