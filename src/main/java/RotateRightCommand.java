public class RotateRightCommand implements Command {

    private final Rover rover;

    public RotateRightCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void apply(Rover rover) {
        rover.rotateRight();
    }


}
