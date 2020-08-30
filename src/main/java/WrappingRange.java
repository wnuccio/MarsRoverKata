public class WrappingRange {
    private int min;
    private int max;

    public WrappingRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int wrappedValue(int i) {
        if (i < min) return max;
        if (i > max) return min;
        return i;
    }
}
