public class RotateCommand implements Command {

    private Rotation rotation;

    public RotateCommand(Rotation rotation) {
        this.rotation = rotation;
    }

    @Override
    public void applyTo(Rover rover) {
        rover.applyRotation(rotation);
    }


}
