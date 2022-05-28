package fr.zbar.kata.marsrover;

import java.util.function.Function;

public record Position(Point point, Direction direction) {
    public static final Position INIT = new Position(Point.INIT, Direction.NORTH);

    private Position rotate(String cmd) {
        return new Position(point, direction.rotate(cmd));
    }

    private Position move(Grid grid) {
        return new Position(direction.move(grid,point), direction);
    }

    public static class PositionFunction implements Function<String, Position> {


        private final Grid grid;
        private Position position;

        public PositionFunction(Grid grid, Position position) {
            this.grid = grid;
            this.position = position;
        }

        @Override
        public Position apply(String cmd) {
            if ("M".equals(cmd)) {
                position = position.move(grid);
                return position;
            }
            position = position.rotate(cmd);
            return position;
        }

    }
}
