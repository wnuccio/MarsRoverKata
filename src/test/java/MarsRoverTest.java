import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {


    private MarsRover marsRover;

    @BeforeEach
    void setUp() {
        marsRover = new MarsRover();
    }

    @Test
    public void should_stay_into_start_position_after_empty_command() {
        String output = marsRover.execute("");

        assertEquals("0:0:N", output);
    }

    @Test
    public void should_advance_from_one_to_nine_positions_towards_N() {
        assertEquals("0:1:N", marsRover.execute("M"));
        assertEquals("0:2:N", marsRover.execute("MM"));
        assertEquals("0:5:N", marsRover.execute("MMMMM"));
        assertEquals("0:9:N", marsRover.execute("MMMMMMMMM"));
    }

}
