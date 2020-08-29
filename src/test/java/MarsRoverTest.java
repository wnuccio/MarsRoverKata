import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.Console;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void should_stay_into_start_position_after_empty_command() {
        assertEquals("0:0:N", new MarsRover().execute(""));
    }

    @Test
    void should_advance_from_one_to_nine_positions_towards_N() {
        assertEquals("0:1:N", new MarsRover().execute("M"));
        assertEquals("0:2:N", new MarsRover().execute("MM"));
        assertEquals("0:5:N", new MarsRover().execute("MMMMM"));
        assertEquals("0:9:N", new MarsRover().execute("MMMMMMMMM"));
    }

    @Test
    void should_rotate_to_left() {
        assertEquals("0:0:W", new MarsRover().execute("L"));
        assertEquals("0:0:S", new MarsRover().execute("LL"));
        assertEquals("0:0:E", new MarsRover().execute("LLL"));
        assertEquals("0:0:N", new MarsRover().execute("LLLL"));
        assertEquals("0:0:W", new MarsRover().execute("LLLLL"));
    }

    @Test
    void should_move_and_then_rotate_one_time() {
        assertEquals("0:1:W", new MarsRover().execute("ML"));
        assertEquals("0:1:E", new MarsRover().execute("MR"));
    }

    @Test
    void should_rotate_right() {
        assertEquals("0:0:E", new MarsRover().execute("R"));
        assertEquals("0:0:S", new MarsRover().execute("RR"));
        assertEquals("0:0:W", new MarsRover().execute("RRR"));
        assertEquals("0:0:N", new MarsRover().execute("RRRR"));
        assertEquals("0:0:E", new MarsRover().execute("RRRRR"));
    }

    @Test
    void should_alternate_to_move_and_rotate() {
        assertEquals("1:1:N", new MarsRover().execute("MRML"));
    }

}
