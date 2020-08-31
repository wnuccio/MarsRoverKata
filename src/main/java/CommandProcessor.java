public class CommandProcessor {
    private final CommandExtractor commandExtractor;
    private final Rover rover;

    public CommandProcessor(CommandExtractor commandExtractor, Rover rover) {
        this.commandExtractor = commandExtractor;
        this.rover = rover;
    }

    public Output execute() {
        applyAllCommands();
        return rover.produceOutput();
    }

    private void applyAllCommands() {
        while(commandExtractor.hasCommand()) {
            Command command = commandExtractor.nextCommand();
            command.applyTo(rover);
        }
    }

}
