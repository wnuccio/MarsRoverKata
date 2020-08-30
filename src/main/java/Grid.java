public class Grid {
    private final int GRID_SIZE = 10;
    private final int MIN_COORDINATE = 0;
    private final int MAX_COORDINATE = GRID_SIZE - 1;
    private final Integer obstacleX;
    private final Integer obstacleY;

    public Grid() {
        this(null, null);
    }

    public Grid(Integer x, Integer y) {
        this.obstacleX = x;
        this.obstacleY = y;
    }

    public int correctCoordinateByWrapping(int coordinate) {
        if (coordinate < MIN_COORDINATE) return MAX_COORDINATE;
        if (coordinate > MAX_COORDINATE) return MIN_COORDINATE;
        return coordinate;
    }

    public boolean hasObstacleAt(int x, int y) {
        if (noObstacle()) return false;
        return obstacleX.equals(x) && obstacleY.equals(y);
    }

    private boolean noObstacle() {
        return obstacleX == null || obstacleY == null;
    }
}
