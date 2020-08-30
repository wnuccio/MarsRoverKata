public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean hasCoordinates(int x, int y) {
        return this.x == x && this.y == y;
    }
}
