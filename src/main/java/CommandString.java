public class CommandString {
    private final String commandString;
    private final Directions directions;

    public CommandString(String commandString) {
        this.commandString = commandString;
        this.directions = new Directions();
    }

    public Output execute(Grid grid) {
        Rover rover = new Rover();
        applyAllCommands(rover, grid);
        return rover.produceOutput();
    }

    private Command createCommand(char commandChar, Grid grid) {
        if (commandChar == 'M') return new MoveCommand(grid);
        if (commandChar == 'L') return new RotateCommand(directions::rotateToLeft);
        if (commandChar == 'R') return new RotateCommand(directions::rotateToRight);
        throw new IllegalArgumentException("Invalid command char: " + commandChar);
    }

    private void applyAllCommands(Rover rover, Grid grid) {
        for (char commandChar : commandString.toCharArray()) {
            Command command = createCommand(commandChar, grid);
            command.applyTo(rover);
        }
    }

}
