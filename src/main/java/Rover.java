public class Rover {
    private OrientedPosition orientedPosition;
    private boolean obstacleEncountered;

    public Rover(OrientedPosition startingPosition) {
        this.orientedPosition = startingPosition;
        this.obstacleEncountered = false;
    }

    public void moveOnGrid(Grid grid) {
        this.obstacleEncountered = orientedPosition.hasObstacleToMovement(grid);
        if (this.obstacleEncountered) return;

        this.orientedPosition = orientedPosition.moveOnGrid(grid);
    }

    public void rotate(Rotation rotation) {
        orientedPosition = orientedPosition.rotate(rotation);
    }

    public void writeOutput(Output output) {
        output.obstacleEncountered(obstacleEncountered);
        orientedPosition.writeOutput(output);
    }

    public void accept(Command command) {
        if (this.obstacleEncountered) return;
        command.applyTo(this);
    }
}
