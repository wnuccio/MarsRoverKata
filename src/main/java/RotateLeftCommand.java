public class RotateLeftCommand implements Command {

    public RotateLeftCommand() {
    }

    @Override
    public void apply(Rover rover) {
        rover.rotateLeft();
    }


}
