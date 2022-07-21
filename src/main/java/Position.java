public class Position {
    private Direction direction;
    private Coordinate coordinate;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public Position(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return coordinate.xWidth + " " + coordinate.yWidth + " " + direction + "\n";
    }
}
