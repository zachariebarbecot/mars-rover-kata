package fr.zbar.kata.marsrover;

import fr.zbar.kata.marsrover.position.Position;
import fr.zbar.kata.marsrover.position.Position.PositionFunction;

public final class MarsRover {

    private final Grid grid;
    private final Position position;

    public MarsRover(Grid grid) {
        this.grid = grid;
        this.position = Position.INIT;
    }

    public Position execute(Command command) {
        PositionFunction function = new PositionFunction(grid, position);
        try {
            return command.stream()
                    .map(function)
                    .reduce(Position.INIT, (f, s) -> s);

        } catch (ObstacleException ex) {
            return ex.position();
        }
    }

}
