package fr.zbar.kata.marsrover.position;

import fr.zbar.kata.marsrover.Direction;
import fr.zbar.kata.marsrover.Grid;
import fr.zbar.kata.marsrover.ObstacleException;
import fr.zbar.kata.marsrover.Point;

import java.util.function.Function;

public sealed interface Position
        permits ObstaclePosition, OpenPosition {
    Position INIT = new OpenPosition(Point.INIT, Direction.NORTH);

    Point point();

    Direction direction();

    private Position rotate(String cmd) {
        return new OpenPosition(point(), direction().rotate(cmd));
    }

    private Position move(Grid grid) {
        Point nextPoint = direction().move(grid, point());
        if (grid.isObstacle(nextPoint)) {
            throw new ObstacleException(new ObstaclePosition(point(), direction()));
        }
        return new OpenPosition(nextPoint, direction());
    }

    class PositionFunction implements Function<String, Position> {

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
