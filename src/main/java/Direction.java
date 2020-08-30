public enum Direction {
    N(Point::upward),
    E(Point::atRight),
    S(Point::down),
    W(Point::atLeft);

    private final NextPoint nextPoint;

    Direction(NextPoint pointFunction) {
        this.nextPoint = pointFunction;
    }

    public Point getNextPosition(Point currentPosition) {
        return nextPoint.after(currentPosition);
    }

}