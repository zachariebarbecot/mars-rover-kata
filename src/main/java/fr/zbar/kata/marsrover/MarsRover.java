package fr.zbar.kata.marsrover;

import fr.zbar.kata.marsrover.Position.PositionFunction;

public final class MarsRover {

    private final Position position;

    public MarsRover() {
        this.position = Position.INIT;
    }

    public Position execute(Command command) {
        PositionFunction function = new PositionFunction(position);
        return command.stream()
                .map(function)
                .reduce(Position.INIT, (f, s) -> s);
    }

}
