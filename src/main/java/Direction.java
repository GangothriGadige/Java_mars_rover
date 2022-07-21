public enum Direction {
    N(new Coordinate(0, 1)),
    S(new Coordinate(0, -1)),
    E(new Coordinate(1, 0)),
    W(new Coordinate(-1, 0));
    Coordinate coordinate;

    Direction(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

}
