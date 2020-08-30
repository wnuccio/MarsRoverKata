import java.util.ArrayList;
import java.util.List;

public class Grid {
    private WrappingRange coordinateRange;
    private List<Point> obstacles;

    public Grid() {
        int size = 10;
        coordinateRange = new WrappingRange(0, size - 1);
        this.obstacles = new ArrayList<>();
    }

    public Grid addObstacle(int x, int y) {
        this.obstacles.add(new Point(x, y));
        return this;
    }

    public int wrappedCoordinate(int coordinate) {
        return coordinateRange.wrappedValue(coordinate);
    }

    public boolean hasObstacleAt(int x, int y) {
        return obstacles
                .stream()
                .anyMatch(obstacle -> obstacle.hasCoordinates(x, y));
    }

}
