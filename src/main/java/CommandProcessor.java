public class CommandProcessor {
    private final CommandExtractor commandExtractor;
    private final RoverCommandConsumer roverCommandConsumer;

    public CommandProcessor(CommandExtractor commandExtractor, RoverCommandConsumer roverCommandConsumer) {
        this.commandExtractor = commandExtractor;
        this.roverCommandConsumer = roverCommandConsumer;
    }

    public Output execute() {
        applyAllCommands();
        return roverCommandConsumer.buildOutput();
    }

    private void applyAllCommands() {
        while(commandExtractor.hasCommand()) {
            Command command = commandExtractor.nextCommand();
            roverCommandConsumer.accept(command);
        }
    }

}
