public enum Direction {
    N(Point::upward),
    E(Point::atRight),
    S(Point::down),
    W(Point::atLeft);

    private static final Directions directions = new Directions();
    private final NextPoint nextPoint;

    Direction(NextPoint pointFunction) {
        this.nextPoint = pointFunction;
    }

    public Direction rotateLeft() {
        return rotateTo(-1);
    }

    public Direction rotateRight() { return rotateTo(+1); }

    private Direction rotateTo(int directionModifier) {
        return directions.applyRotation(this, directionModifier);
    }

    public void moveOnGrid(Rover rover, Grid grid) {
        rover.moveOnGrid(grid, nextPoint);
    }
}