import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {


    @Test
    public void should_stay_into_start_position_after_empty_command() {
        MarsRover marsRover = new MarsRover();
        String output = marsRover.execute("");

        assertEquals("0:0:N", output);
    }

    @Test
    public void should_advance_one_position_towards_N() {
        MarsRover marsRover = new MarsRover();
        String output = marsRover.execute("M");

        assertEquals("0:1:N", output);
    }
}
