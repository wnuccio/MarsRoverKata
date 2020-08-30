import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircularIntRangeTest {

    @Test
    void should_return_given_value_if_into_range() {
        assertEquals(1, new CircularIntRange(0, 3).wrappedValue(1));
    }
}
