public class Coordinate {
    int xWidth;
    int yWidth;

    public Coordinate(int xWidth, int yWidth) {
        this.xWidth = xWidth;
        this.yWidth = yWidth;
    }

    public Coordinate update(Direction direction) {
        return new Coordinate(xWidth + direction.coordinate.xWidth, yWidth + direction.coordinate.yWidth);
    }
}
