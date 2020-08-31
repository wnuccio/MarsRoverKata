public class Rover {
    private OrientedPosition orientedPosition;
    private boolean obstacleEncountered;

    public Rover(OrientedPosition startingPosition) {
        this.orientedPosition = startingPosition;
        this.obstacleEncountered = false;
    }

    public void moveOnGrid(Grid grid) {
        OrientedPosition newOrientedPosition = orientedPosition.moveOnGrid(grid);

        if (newOrientedPosition.matchesObstacleOnGrid(grid)) {
            this.obstacleEncountered = true;
            return;
        }

        this.orientedPosition = newOrientedPosition;
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
