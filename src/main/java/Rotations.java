import java.util.Arrays;

public class Rotations {
    private final Direction[] directionArray;
    private WrappingRange indexRange;

    public Rotations() {
        directionArray = new Direction[] {
                Direction.N,
                Direction.E,
                Direction.S,
                Direction.W
        };
        
        indexRange = new WrappingRange(0, directionArray.length-1);
    }

    private int indexOf(Direction direction) {
        return Arrays.asList(directionArray).indexOf(direction);
    }

    private Direction applyRotation(Direction direction, int rotationSign) {
        int currentIndex = indexOf(direction);
        int newIndex = indexRange.wrappedValue(currentIndex + rotationSign);
        return directionArray[newIndex];
    }

    public Direction rotateToLeft(Direction direction) {
        return applyRotation(direction, -1);
    }

    public Direction rotateToRight(Direction direction) {
        return applyRotation(direction, +1);
    }
}
