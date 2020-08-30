public class Grid {
    private final int GRID_SIZE = 10;
    private final int MIN_COORDINATE = 0;
    private final int MAX_COORDINATE = GRID_SIZE - 1;

    public int correctCoordinateByWrapping(int coordinate) {
        if (coordinate < MIN_COORDINATE) return MAX_COORDINATE;
        if (coordinate > MAX_COORDINATE) return MIN_COORDINATE;
        return coordinate;
    }
}
