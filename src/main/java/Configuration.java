import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private Grid grid;

    public Configuration(Grid grid) {
        this.grid = grid;
    }

    private CommandFactory commandFactory() {
        Rotations rotations = new Rotations();
        Map<Character, Command> commandMapImpl = new HashMap<>();
        commandMapImpl.put('M', new MoveCommand(grid));
        commandMapImpl.put('L', new RotateCommand(rotations::rotateToLeft));
        commandMapImpl.put('R', new RotateCommand(rotations::rotateToRight));
        return new CommandFactory(commandMapImpl);
    }

    public CommandProcessor commandProcessor(String commandString) {
        CommandExtractor commandExtractor = new CommandExtractor(commandString.toCharArray(), commandFactory());
        return new CommandProcessor(commandExtractor, new Rover());
    }
}
