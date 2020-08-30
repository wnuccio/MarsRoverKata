import java.util.Arrays;
import java.util.function.Consumer;

public enum Command {
    M(MarsRover::advance),
    L(MarsRover::rotateLeft),
    R(MarsRover::rotateRight);

    private final Consumer<MarsRover> commandMethod;

    Command(Consumer<MarsRover> commandMethod) {
        this.commandMethod = commandMethod;
    }

    public static Command byChar(char commandChar) {
        return Arrays.stream(values())
                .filter(c -> commandChar == c.asChar())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid command char: " + commandChar));
    }

    private char asChar() {
        return this.name().charAt(0);
    }

    void apply(MarsRover marsRover) {
        commandMethod.accept(marsRover);
    }
}
