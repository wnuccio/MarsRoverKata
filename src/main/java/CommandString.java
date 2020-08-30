public class CommandString {
    private final String commandString;

    public CommandString(String commandString) {
        this.commandString = commandString;
    }

    public Output execute(MarsRover marsRover) {
        moveToFinalPosition(marsRover);
        return buildOutputString(marsRover);
    }

    private void moveToFinalPosition(MarsRover marsRover) {
        for (char commandChar : commandString.toCharArray()) {
            Command command = Command.byChar(commandChar);
            command.apply(marsRover);
        }
    }

    private Output buildOutputString(MarsRover marsRover) {
        Output output = new Output(marsRover.obstacleEncountered, marsRover.direction);
        marsRover.position.addTo(output);
        return output;
    }

}
