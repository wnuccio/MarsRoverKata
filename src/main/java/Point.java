public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean hasPosition(Point that) {
        return this.x == that.x && this.y == that.y;
    }

    public Point atRight() {
        return new Point(x + 1, y);
    }

    public Point atLeft() {
        return new Point(x - 1, y);
    }

    public Point upward() {
        return new Point(x, y + 1);
    }

    public Point down() {
        return new Point(x, y - 1);
    }

    public Point wrapped(WrappingRange coordinateRange) {
        int wx = coordinateRange.wrappedValue(x);
        int wy = coordinateRange.wrappedValue(y);

        return new Point(wx, wy);
    }

    public void writeOutput(Output output) {
        output.finalPosition(x, y);
    }
}
