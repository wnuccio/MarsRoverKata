public class OrientedPosition {
    private Point point;
    private Direction direction;

    public OrientedPosition(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public boolean hasObstacleToMovement(Grid grid) {
        return grid.hasObstacleAt(positionAfterMovement(grid));
    }

    public OrientedPosition moveOnGrid(Grid grid) {
        Point newPosition = positionAfterMovement(grid);
        return new OrientedPosition(newPosition, direction);
    }

    private Point positionAfterMovement(Grid grid) {
        Point newPosition = direction.getNextPosition(point);
        newPosition = grid.wrappedPoint(newPosition);
        return newPosition;
    }

    public OrientedPosition rotate(Rotation rotation) {
        Direction newDirection = rotation.apply(direction);
        return new OrientedPosition(point, newDirection);

    }

    public void writeOutput(Output output) {
        output.finalDirection(direction);
        point.writeOutput(output);
    }
}
