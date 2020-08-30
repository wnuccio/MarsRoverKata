public class MoveCommand implements Command {
    private final Rover rover;
    private final Grid grid;

    public MoveCommand(Rover rover, Grid grid) {
        this.rover = rover;
        this.grid = grid;
    }

    @Override
    public void apply(Rover rover) {
        rover.moveOnGrid(grid);
    }
}
