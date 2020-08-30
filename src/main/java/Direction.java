import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum Direction {
    N, W, S, E;

    @Override
    public String toString() {
        return name();
    }

    void advance(MarsRover marsRover) {
        if (this == N) {
            marsRover.up();
        } else if (this == S) {
            marsRover.down();
        } else if (this == E) {
            marsRover.right();
        } else if (this == W) {
            marsRover.left();
        }
    }

    Direction rotate(char ch) {
        List<Direction> directions = Arrays.asList(values());
        int directionIndex = directions.indexOf(this);
        directionIndex = ch == 'L' ? directionIndex + 1 : directionIndex - 1;

        if (directionIndex < 0) {
            directionIndex = 3;
        } else if (directionIndex > 3) {
            directionIndex = 0;
        }

        return directions.get(directionIndex);
    }

}