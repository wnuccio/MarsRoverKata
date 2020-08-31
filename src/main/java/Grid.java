import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {
    private final WrappingRange coordinateRange;
    private final List<Point> obstacles;

    public Grid(Point... obstacles) {
        int size = 10;
        this.coordinateRange = new WrappingRange(0, size - 1);
        this.obstacles = new ArrayList<>(); this.obstacles.addAll(Arrays.asList(obstacles));
    }

    public static Point obstacle(int x, int y) {
        return new Point(x, y);
    }

    public boolean hasObstacleAt(Point point) {
        return obstacles
                .stream()
                .anyMatch(obstacle -> obstacle.hasPosition(point));
    }

    public Point wrappedPoint(Point newPosition) {
        return newPosition.wrapped(coordinateRange);

    }
}
