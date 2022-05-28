package fr.zbar.kata.marsrover;

import java.util.function.Function;

public record Position(Point point, Direction direction) {
    public static final Position INIT = new Position(Point.INIT, Direction.NORTH);

    private Position rotate(String cmd) {
        return new Position(point, direction.rotate(cmd));
    }

    private Position move() {
        return new Position(direction.move(point), direction);
    }

    public static class PositionFunction implements Function<String, Position> {


        private Position position;

        public PositionFunction(Position position) {
            this.position = position;
        }

        @Override
        public Position apply(String cmd) {
            if ("M".equals(cmd)) {
                position = position.move();
                return position;
            }
            position = position.rotate(cmd);
            return position;
        }

    }
}
