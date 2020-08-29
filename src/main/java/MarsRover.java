public class MarsRover {


    public String execute(String s) {
        String direction;
        int yPosition;

        if (s.contains("L")) {
            yPosition = 0;
            direction = direction(numOfL(s));
        } else {
            yPosition = s.length();
            direction = direction(0);
        }

        return String.format("0:%d:%s", yPosition, direction);
    }

    private String direction(int numberOfLs) {
        String[] directions = new String[]{"N", "W", "S", "E"};
        return directions[numberOfLs];
    }

    private int numOfL(String s) {
        return (int) s.chars().filter(ch -> ch == 'L').count();
    }
}
