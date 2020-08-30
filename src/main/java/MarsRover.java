public class MarsRover {
    private final Grid grid;

    public MarsRover(Grid grid) {
        this.grid = grid;
    }

    public String execute(String commandString) {
        CommandString commands = new CommandString(commandString);
        Output output = commands.execute(grid);
        return output.asString();
    }
}
