public class MarsRover {

    private int y;
    private int x;
    private Direction direction;

    public MarsRover() {
        x = 0;
        y = 0;
        direction = Direction.N;
    }

    public String execute(String commands) {
        computeFinalPosition(commands);
        return buildOutputString();
    }

    private void computeFinalPosition(String commands) {
        for (char ch : commands.toCharArray()) {
            if (ch == 'M') {
                direction.advance(this);

            } else {
                direction = direction.rotate(ch);
            }
        }
    }

    void right() {
        x++;
    }

    void left() {
        x--;
    }

    void up() {
        y++;
    }

    void down() {
        y--;
    }

    private String buildOutputString() {
        return String.format("%d:%d:%s", x, y, direction.toString());
    }

}
