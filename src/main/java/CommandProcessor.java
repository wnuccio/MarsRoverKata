public class CommandProcessor {
    private final CommandExtractor commandExtractor;
    private final RoverCommandConsumer roverCommandConsumer;

    public CommandProcessor(CommandExtractor commandExtractor, RoverCommandConsumer roverCommandConsumer) {
        this.commandExtractor = commandExtractor;
        this.roverCommandConsumer = roverCommandConsumer;
    }

    public Output execute() {
        while(commandExtractor.hasCommand()) {
            Command command = commandExtractor.nextCommand();
            roverCommandConsumer.accept(command);
        }

        return roverCommandConsumer.buildOutput();
    }

}
