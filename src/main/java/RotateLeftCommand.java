public class RotateLeftCommand implements Command {

    private final Rover rover;

    public RotateLeftCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void apply(Rover rover) {
        rover.rotateLeft();
    }


}
