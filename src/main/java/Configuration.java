import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private Grid grid;

    public Configuration(Grid grid) {
        this.grid = grid;
    }
    private CommandFactory commandFactory() {
        Rotations rotations = new Rotations();
        Map<Character, Command> commandMap = new HashMap<>();
        commandMap.put('M', new MoveCommand(grid));
        commandMap.put('L', new RotateCommand(rotations::rotateToLeft));
        commandMap.put('R', new RotateCommand(rotations::rotateToRight));
        return new CommandFactory(commandMap);
    }

    private RoverCommandConsumer roverCommandConsumer() {
        Rover rover = new Rover(new OrientedPosition(new Point(0, 0), Direction.N));
        return new RoverCommandConsumer(rover, new Output());
    }

    private CommandExtractor commandExtractor(String commandString) {
        return new CommandExtractor(commandString.toCharArray(), commandFactory());
    }

    public CommandProcessor commandProcessor(String commandString) {
        return new CommandProcessor(commandExtractor(commandString), roverCommandConsumer());
    }
}
