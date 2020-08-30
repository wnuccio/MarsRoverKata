import java.util.List;
import java.util.function.Consumer;

import static java.util.Arrays.asList;

public enum Direction {
    N(MarsRover::moveUp),
    E(MarsRover::moveRight),
    S(MarsRover::moveDown),
    W(MarsRover::moveLeft);

    private static final List<Direction> directions = asList(values());
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

    public Direction rotateRight() {
        return rotateTo(+1);
    }

    private int wrapIfOutOfBound(int newIndex) {
        int MAX_INDEX = 3;
        int MIN_INDEX = 0;
        if (newIndex > MAX_INDEX) return MIN_INDEX;
        if (newIndex < MIN_INDEX) return 3;
        return newIndex;
    }

    private Direction rotateTo(int directionModifier) {
        int newIndex = wrapIfOutOfBound(currentIndex() + directionModifier);
        return directionAtIndex(newIndex);
    }

    private Direction directionAtIndex(int directionIndex) {
        return directions.get(directionIndex);
    }

    private int currentIndex() {
        return directions.indexOf(this);
    }
}