public class RoverCommandConsumer {
    private Rover rover;
    private Output output;

    public RoverCommandConsumer(Rover rover, Output output) {
        this.rover = rover;
        this.output = output;
    }

    public void accept(Command command) {
        rover.accept(command);
    }

    public Output buildOutput() {
        rover.writeOutput(output);
        return output;
    }
}
