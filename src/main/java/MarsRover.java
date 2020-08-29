public class MarsRover {

    public String execute(String s) {
        int y = countCharacter(s, 'M');
        String direction = computeDirection(countCharacter(s, 'L'));
        return buildOutputString(y, direction);
    }

    private String buildOutputString(int y, String direction) {
        return String.format("0:%d:%s", y, direction);
    }

    private String computeDirection(int numberOfLs) {
        String[] directions = new String[]{"N", "W", "S", "E"};
        int directionIndex = numberOfLs % 4;
        return directions[directionIndex];
    }

    private int countCharacter(String s, char character) {
        return (int) s.chars().filter(ch -> ch == character).count();
    }
}
