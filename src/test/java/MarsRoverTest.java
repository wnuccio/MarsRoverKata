import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MarsRoverTest {


    @Test public void
    should_stay_into_start_position_after_empty_command() {
        MarsRover marsRover = new MarsRover();
        String output = marsRover.execute("");

        assertEquals("0:0:N", output);
    }
}
