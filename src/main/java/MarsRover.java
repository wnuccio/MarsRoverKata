import java.util.Arrays;

public class MarsRover {

    private int y;
    private int x;
    private String currentDirection;

    public MarsRover() {
        x = 0;
        y = 0;
        currentDirection = "N";
    }

    public String execute(String commands) {
        computeFinalPosition(commands);
        return buildOutputString();
    }

    private void computeFinalPosition(String commands) {
        for (char ch: commands.toCharArray()) {
            if (ch == 'M') {
                advanceInDirection();

            } else {
                changeCurrentDirection(ch);
            }
        }
    }

    private void changeCurrentDirection(int ch) {
        String[] directions = new String[]{"N", "W", "S", "E"};
        int directionIndex = Arrays.asList(directions).indexOf(currentDirection);
        directionIndex = ch == 'L' ? directionIndex + 1 : directionIndex - 1;
        if (directionIndex < 0) directionIndex = 3;
        else if (directionIndex > 3) directionIndex = 0;
        this.currentDirection = directions[directionIndex];
    }

    private void advanceInDirection() {
        if ("N".equals(currentDirection)) {
            y++;
        } else if ("S".equals(currentDirection)) {
            y--;
        } else if ("E".equals(currentDirection)) {
            x++;
        } else if ("W".equals(currentDirection)) {
            x--;
        }
    }

    private String buildOutputString() {
        return String.format("%d:%d:%s", x, y, currentDirection);
    }

}
