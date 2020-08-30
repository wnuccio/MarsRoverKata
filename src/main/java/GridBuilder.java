public class GridBuilder {

    private final Grid grid;

    public GridBuilder() {
        this.grid = new Grid();
    }

    public GridBuilder addObstacle(int x, int y) {
        grid.obstacles.add(new Point(x, y));
        return this;
    }

    public Grid build() {
        return grid;
    }
}
