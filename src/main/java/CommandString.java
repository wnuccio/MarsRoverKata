public class CommandString {
    private final String commandString;

    public CommandString(String commandString) {
        this.commandString = commandString;
    }

    public static Command createCommand(char commandChar, Grid grid) {
        if (commandChar == 'M') return new MoveCommand(grid);
        if (commandChar == 'L') return new RotateLeftCommand();
        if (commandChar == 'R') return new RotateRightCommand();
        throw new IllegalArgumentException("Invalid command char: " + commandChar);
    }

    public Output execute(Grid grid) {
        Rover rover = new Rover();
        applyAllCommands(rover, grid);
        return rover.produceOutput();
    }

    private void applyAllCommands(Rover rover, Grid grid) {
        for (char commandChar : commandString.toCharArray()) {
            Command command = createCommand(commandChar, grid);
            command.apply(rover);
        }
    }

}
