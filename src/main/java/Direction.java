import java.util.function.Function;

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

    public void advance(MarsRover marsRover) {
        marsRover.moveOn(nextPoint);
    }

    public Direction rotateLeft() {
        return rotateTo(-1);
    }

    public Direction rotateRight() { return rotateTo(+1); }

    private Direction rotateTo(int directionModifier) {
        return directions.applyRotation(this, directionModifier);
    }

}