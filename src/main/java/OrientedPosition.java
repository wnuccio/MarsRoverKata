public class OrientedPosition {
    private Point point;
    private Direction direction;

    public OrientedPosition(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public boolean hasObstacleToMovement(Grid grid) {
        OrientedPosition positionAfterMovement = moveOnGrid(grid);
        return grid.hasObstacleAt(positionAfterMovement.point);
    }

    public OrientedPosition moveOnGrid(Grid grid) {
        Point newPoint = grid.wrappedPoint(direction.getNextPosition(point));
        return new OrientedPosition(newPoint, direction);
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
