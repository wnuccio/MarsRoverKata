import java.util.function.Consumer;

public enum Direction {
    N(MarsRover::moveUp),
    E(MarsRover::moveRight),
    S(MarsRover::moveDown),
    W(MarsRover::moveLeft);

    private static final Directions directions = new Directions();
    private Consumer<MarsRover> movementMethod;

    Direction(Consumer<MarsRover> movementMethod) {
        this.movementMethod = movementMethod;
    }

    @Override
    public String toString() {
        return name();
    }

    public void advance(MarsRover marsRover) {
        this.movementMethod.accept(marsRover);
    }

    public Direction rotateLeft() {
        return rotateTo(-1);
    }

    public Direction rotateRight() { return rotateTo(+1); }

    private Direction rotateTo(int directionModifier) {
        return directions.applyRotation(this, directionModifier);
    }

}