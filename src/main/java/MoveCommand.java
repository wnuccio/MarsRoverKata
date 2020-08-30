public class MoveCommand implements Command {
    private final Grid grid;

    public MoveCommand(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void apply(Rover rover) {
        rover.moveOnGrid(grid);
    }
}
