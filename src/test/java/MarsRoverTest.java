import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {


    private MarsRover marsRover;

    @BeforeEach
    void setUp() {
        marsRover = new MarsRover();
    }

    @Test
    void should_stay_into_start_position_after_empty_command() {
        String output = marsRover.execute("");

        assertEquals("0:0:N", output);
    }

    @Test
    void should_advance_from_one_to_nine_positions_towards_N() {
        assertEquals("0:1:N", marsRover.execute("M"));
        assertEquals("0:2:N", marsRover.execute("MM"));
        assertEquals("0:5:N", marsRover.execute("MMMMM"));
        assertEquals("0:9:N", marsRover.execute("MMMMMMMMM"));
    }

    @Test
    void should_rotate_to_left() {
        assertEquals("0:0:W", marsRover.execute("L"));
        assertEquals("0:0:S", marsRover.execute("LL"));
        assertEquals("0:0:E", marsRover.execute("LLL"));
        assertEquals("0:0:N", marsRover.execute("LLLL"));
        assertEquals("0:0:W", marsRover.execute("LLLLL"));
    }

    @Test
    void should_move_and_then_rotate_left() {
        assertEquals("0:1:W", marsRover.execute("ML"));
    }

    @Test
    void should_rotate_right() {
        assertEquals("0:0:E", marsRover.execute("R"));
    }
}
