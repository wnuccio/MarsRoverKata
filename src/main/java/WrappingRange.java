public class WrappingRange {
    private int min;
    private int max;

    public WrappingRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int wrappedValue(int value) {
        if (value < min) return max;
        if (value > max) return min;
        return value;
    }
}
