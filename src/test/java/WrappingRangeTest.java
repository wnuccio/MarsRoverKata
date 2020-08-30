import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WrappingRangeTest {

    @Test
    void should_return_given_value_if_into_range() {
        assertEquals(1, new WrappingRange(0, 3).wrappedValue(1));
        assertEquals(0, new WrappingRange(0, 3).wrappedValue(0));
        assertEquals(3, new WrappingRange(0, 3).wrappedValue(3));
    }

    @Test
    void should_return_upper_bound_if_value_under_minimum() {
        assertEquals(3, new WrappingRange(0, 3).wrappedValue(-1));
    }

    @Test
    void should_return_lower_bound_if_value_over_maximum() {
        assertEquals(0, new WrappingRange(0, 3).wrappedValue(4));
    }
}
