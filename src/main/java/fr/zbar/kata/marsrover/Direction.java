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

    abstract Direction left();

    abstract Direction right();

    public String value() {
        return value;
    }
}
