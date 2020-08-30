import java.util.List;

import static java.util.Arrays.asList;

public class Directions {
    private final List<Direction> directionList;
    private WrappingRange indexRange;

    public Directions() {
        directionList = asList(
                Direction.N,
                Direction.E,
                Direction.S,
                Direction.W);

        indexRange = new WrappingRange(0, directionList.size()-1);
    }

    private Direction getByIndex(int directionIndex) {
        return directionList.get(directionIndex);
    }

    private int indexOf(Direction direction) {
        return directionList.indexOf(direction);
    }

    public Direction applyRotation(Direction direction, int rotationSign) {
        int currentIndex = indexOf(direction);
        int newIndex = indexRange.wrappedValue(currentIndex + rotationSign);
        return this.getByIndex(newIndex);
    }
}
