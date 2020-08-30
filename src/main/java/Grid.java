public class Grid {
    private final int GRID_SIZE = 10;
    private final int MIN_COORDINATE = 0;
    private final int MAX_COORDINATE = GRID_SIZE - 1;
    private Integer obstacleX;
    private Integer obstacleY;

    public Grid() {
        this.obstacleX = null;
        this.obstacleY = null;
    }

    public Grid addObstacle(int x, int y) {
        this.obstacleX = x;
        this.obstacleY = y;
        return this;
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
