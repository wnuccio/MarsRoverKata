import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void should_stay_into_start_position_after_empty_command() {
        assertEquals("0:0:N", marsRover().execute(""));
    }

    private MarsRover marsRover() {
        return new MarsRover(new Grid());
    }

    @Test
    void should_advance_from_one_to_nine_positions_towards_N() {
        assertEquals("0:1:N", marsRover().execute("M"));
        assertEquals("0:2:N", marsRover().execute("MM"));
        assertEquals("0:5:N", marsRover().execute("MMMMM"));
        assertEquals("0:9:N", marsRover().execute("MMMMMMMMM"));
    }

    @Test
    void should_rotate_to_left() {
        assertEquals("0:0:W", marsRover().execute("L"));
        assertEquals("0:0:S", marsRover().execute("LL"));
        assertEquals("0:0:E", marsRover().execute("LLL"));
        assertEquals("0:0:N", marsRover().execute("LLLL"));
        assertEquals("0:0:W", marsRover().execute("LLLLL"));
    }

    @Test
    void should_move_and_then_rotate_one_time() {
        assertEquals("0:1:W", marsRover().execute("ML"));
        assertEquals("0:1:E", marsRover().execute("MR"));
    }

    @Test
    void should_rotate_right() {
        assertEquals("0:0:E", marsRover().execute("R"));
        assertEquals("0:0:S", marsRover().execute("RR"));
        assertEquals("0:0:W", marsRover().execute("RRR"));
        assertEquals("0:0:N", marsRover().execute("RRRR"));
        assertEquals("0:0:E", marsRover().execute("RRRRR"));
    }

    @Test
    void should_alternate_to_move_and_rotate() {
        assertEquals("1:1:N", marsRover().execute("MRML"));
    }

    @Test
    void should_move_describing_a_square() {
        assertEquals("0:0:W", marsRover().execute("MMRMMRMMRMM"));
    }

    @Test
    void wrap_around_after_moving_up_ten_times() {
        assertEquals("0:0:N", marsRover().execute("MMMMMMMMMM"));
    }

    @Test
    void wrap_around_after_moving_right_ten_times() {
        assertEquals("0:0:E", marsRover().execute("RMMMMMMMMMM"));
    }
}
