import java.util.HashMap;
import java.util.Map;

public class MarsRover {
    private final Grid grid;

    public MarsRover(Grid grid) {
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

    public String execute(String commandString) {
        CommandExtractor commandExtractor = new CommandExtractor(commandString, commandFactory());
        CommandProcessor commands = new CommandProcessor(commandExtractor, new Rover());
        Output output = commands.execute();
        return output.asString();
    }
}
