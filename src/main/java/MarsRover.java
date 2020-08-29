public class MarsRover {

    public String execute(String s) {
        int y = computeY(s);
        String direction = computeDirection(numOfL(s));
        return buildOutputString(y, direction);
    }

    private String buildOutputString(int y, String direction) {
        return String.format("0:%d:%s", y, direction);
    }

    private int computeY(String s) {
        int y;

        if (s.contains("L")) {
            y = 0;
        } else {
            y = s.length();
        }
        return y;
    }

    private String computeDirection(int numberOfLs) {
        String[] directions = new String[]{"N", "W", "S", "E"};
        int directionIndex = numberOfLs % 4;
        return directions[directionIndex];
    }

    private int numOfL(String s) {
        return (int) s.chars().filter(ch -> ch == 'L').count();
    }
}
