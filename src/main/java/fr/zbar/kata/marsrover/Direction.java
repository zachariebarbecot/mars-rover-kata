package fr.zbar.kata.marsrover;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public enum Direction {

    WEST("W") {
        @Override
        public Direction left() {
            return SOUTH;
        }

        @Override
        protected Direction right() {
            return NORTH;
        }

        @Override
        Point moveTo(Grid grid, Point point) {
            if (point.isXEqual(0)) {
                return new Point(grid.maxX() - 1, point.y());
            }
            return new Point(point.x() - 1, point.y());
        }
    },
    NORTH("N") {
        @Override
        public Direction left() {
            return WEST;
        }

        @Override
        protected Direction right() {
            return EAST;
        }

        @Override
        Point moveTo(Grid grid, Point point) {
            if (point.isYEqual(grid.maxY() - 1)) {
                return new Point(point.x(), 0);
            }
            return new Point(point.x(), point.y() + 1);
        }
    },
    SOUTH("S") {
        @Override
        public Direction left() {
            return EAST;
        }

        @Override
        protected Direction right() {
            return WEST;
        }

        @Override
        Point moveTo(Grid grid, Point point) {
            if (point.isYEqual(0)) {
                return new Point(point.x(), grid.maxY() - 1);
            }
            return new Point(point.x(), point.y() - 1);
        }
    },
    EAST("E") {
        @Override
        public Direction left() {
            return NORTH;
        }

        @Override
        protected Direction right() {
            return SOUTH;
        }

        @Override
        Point moveTo(Grid grid, Point point) {
            if (point.isXEqual(grid.maxX() - 1)) {
                return new Point(0, point.y());
            }
            return new Point(point.x() + 1, point.y());
        }
    };

    private final String value;

    Direction(String value) {
        this.value = value;
    }

    public static Map<String, Direction> asMapByValue() {
        return Arrays.stream(values())
                .collect(toMap(Direction::value, Function.identity()));
    }

    public Direction rotate(String cmd) {
        if ("L".equals(cmd)) {
            return left();
        }
        if ("R".equals(cmd)) {
            return right();
        }
        return this;
    }

    public Point move(Grid grid, Point point) {
        return moveTo(grid, point);
    }

    abstract Direction left();

    abstract Direction right();

    abstract Point moveTo(Grid grid, Point point);

    private String value() {
        return value;
    }
}
