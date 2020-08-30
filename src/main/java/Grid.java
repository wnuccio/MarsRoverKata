public class Grid {
    public int maxY() {
        return 10;
    }

    public int maxX() {
        return 10;
    }

    public int incrementX(int x) {
        x++;
        if (x == maxX()) x = 0;
        return x;
    }

    public int decrementX(int x) {
        x--;
        if (x < 0) x = maxX() - 1;
        return x;

    }

    public int incrementY(int y) {
        y++;
        if (y == maxY()) y = 0;
        return y;
    }

    public int decrementY(int y) {
        y--;
        if (y < 0) y = maxY() - 1;
        return y;
    }
}
