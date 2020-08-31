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

    private RoverCommandConsumer roverCommandConsumer() {
        return new RoverCommandConsumer(new Rover(), new Output());
    }

    private CommandExtractor commandExtractor(String commandString) {
        return new CommandExtractor(commandString.toCharArray(), commandFactory());
    }

    public CommandProcessor commandProcessor(String commandString) {
        return new CommandProcessor(commandExtractor(commandString), roverCommandConsumer());
    }
}
