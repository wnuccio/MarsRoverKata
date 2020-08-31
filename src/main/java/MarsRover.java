public class MarsRover {
    private final Grid grid;
    private final Configuration configuration;

    public MarsRover(Grid grid) {
        this.grid = grid;
        this.configuration = new Configuration(grid);
    }

    public String execute(String commandString) {
        CommandProcessor commandProcessor = configuration.commandProcessor(commandString);
        Output output = commandProcessor.execute();
        return output.asString();
    }
}
