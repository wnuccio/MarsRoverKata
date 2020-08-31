import java.util.Map;

public class CommandFactory {
    private final Map<Character, Command> map;

    public CommandFactory(Map<Character, Command> map) {
        this.map = map;
    }

    public Command createCommand(char commandChar) {
        return map.getOrDefault(commandChar, rover -> { });
    }
}
