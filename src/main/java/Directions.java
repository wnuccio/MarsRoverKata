import java.util.Arrays;

public class Directions {
    private final Direction[] directionArray;
    private WrappingRange indexRange;

    public Directions() {

        directionArray = new Direction[] {
                Direction.N,
                Direction.E,
                Direction.S,
                Direction.W
        };
        
        indexRange = new WrappingRange(0, directionArray.length-1);
    }

    private Direction getByIndex(int directionIndex) {
        return directionArray[directionIndex];
    }

    private int indexOf(Direction direction) {
        return Arrays.asList(directionArray).indexOf(direction);
    }

    public Direction applyRotation(Direction direction, int rotationSign) {
        int currentIndex = indexOf(direction);
        int newIndex = indexRange.wrappedValue(currentIndex + rotationSign);
        return this.getByIndex(newIndex);
    }
}
