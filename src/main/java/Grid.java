import java.util.ArrayList;
import java.util.List;

public class Grid {
    private WrappingRange coordinateRange;
    List<Point> obstacles;

    public Grid() {
        int size = 10;
        coordinateRange = new WrappingRange(0, size - 1);
        this.obstacles = new ArrayList<>();
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
