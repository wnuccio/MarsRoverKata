import java.util.ArrayList;
import java.util.List;

public class Grid {
    private final int GRID_SIZE = 10;
    private final int MIN_COORDINATE = 0;
    private final int MAX_COORDINATE = GRID_SIZE - 1;
    private Integer obstacleX;
    private Integer obstacleY;
    private List<Obstacle> obstacles;

    public Grid() {
        this.obstacleX = null;
        this.obstacleY = null;
        this.obstacles = new ArrayList<>();
    }

    public Grid addObstacle(int x, int y) {
        this.obstacleX = x;
        this.obstacleY = y;
        this.obstacles.add(new Obstacle(x, y));
        return this;
    }

    public int correctCoordinateByWrapping(int coordinate) {
        if (coordinate < MIN_COORDINATE) return MAX_COORDINATE;
        if (coordinate > MAX_COORDINATE) return MIN_COORDINATE;
        return coordinate;
    }

    public boolean hasObstacleAt(int x, int y) {
        return obstacles
                .stream()
                .anyMatch(obstacle -> obstacle.hasCoordinates(x, y));
    }

}
