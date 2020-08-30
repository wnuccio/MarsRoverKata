import java.util.List;

import static java.util.Arrays.asList;

public class Directions {
    private final List<Direction> directionList;
    private WrappingRange indexRange;

    private int wrapIfOutOfBound(int newIndex) {
        return indexRange.wrappedValue(newIndex);
    }

    public Directions() {
        directionList = asList(
                Direction.N,
                Direction.E,
                Direction.S,
                Direction.W);

        indexRange = new WrappingRange(0, directionList.size()-1);
    }

    public Direction getByIndex(int directionIndex) {
        return directionList.get(directionIndex);
    }

    public int indexOf(Direction direction) {
        return directionList.indexOf(direction);
    }

    public Direction applyRotation(Direction direction, int directionModifier) {
        int currentIndex = indexOf(direction);
        int newIndex = wrapIfOutOfBound(currentIndex + directionModifier);
        return this.getByIndex(newIndex);
    }
}
