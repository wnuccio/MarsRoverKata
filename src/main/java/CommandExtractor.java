public class CommandExtractor {
    private final char[] commandCharArray;
    private CommandFactory commandFactory;
    private int i;

    public CommandExtractor(String commandString, CommandFactory commandFactory) {
        this.commandCharArray = commandString.toCharArray();
        this.commandFactory = commandFactory;
        this.i = 0;
    }

    public boolean hasCommand() {
        return i < commandCharArray.length;
    }

    public Command nextCommand() {
        char commandChar = commandCharArray[i++];
        return commandFactory.createCommand(commandChar);
    }
}
