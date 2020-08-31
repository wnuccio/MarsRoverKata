import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grid {
    private final WrappingRange coordinateRange;
    private final Set<Point> obstacles;

    public Grid(Point... obstacles) {
        int size = 10;
        this.coordinateRange = new WrappingRange(0, size - 1);
        this.obstacles = Stream.of(obstacles).collect(Collectors.toSet());
    }

    public static Point obstacle(int x, int y) {
        return new Point(x, y);
    }

    public boolean hasObstacleAt(Point point) {
        return obstacles.contains(point);
    }

    public Point wrappedPoint(Point newPosition) {
        return newPosition.wrapped(coordinateRange);

    }
}
