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
        Point moveTo(Point point) {
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
        Point moveTo(Point point) {
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
        Point moveTo(Point point) {
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
        Point moveTo(Point point) {
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

    public Point move(Point point) {
        return moveTo(point);
    }

    abstract Direction left();

    abstract Direction right();

    abstract Point moveTo(Point point);

    public String value() {
        return value;
    }
}
