public class RotateRightCommand implements Command {

    public RotateRightCommand() {
    }

    @Override
    public void apply(Rover rover) {
        rover.rotateRight();
    }


}
