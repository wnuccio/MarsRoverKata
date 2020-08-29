public class MarsRover {

    public String execute(String s) {
        int y = countCharacter(s, 'M');
        String direction = computeDirection(s);
        return buildOutputString(y, direction);
    }

    private String buildOutputString(int y, String direction) {
        return String.format("0:%d:%s", y, direction);
    }

    private String computeDirection(String s) {
        int rotationIndex = (countCharacter(s, 'L') - countCharacter(s, 'R') ) % 4;
        int directionIndex = rotationIndex >= 0 ? rotationIndex : 4 - (-1 * rotationIndex);

    String[] directions = new String[]{"N", "W", "S", "E"};
        return directions[directionIndex];
    }

    private int countCharacter(String s, char character) {
        return (int) s.chars().filter(ch -> ch == character).count();
    }
}
