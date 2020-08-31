public class GridBuilder {

    private final Grid grid;

    public GridBuilder() {
        this.grid = new Grid();
    }

    public GridBuilder addObstacle(int x, int y) {
        grid.addObstacle(new Point(x, y));
        return this;
    }

    public Grid build() {
        return grid;
    }
}
