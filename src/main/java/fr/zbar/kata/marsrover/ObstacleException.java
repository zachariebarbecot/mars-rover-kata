package fr.zbar.kata.marsrover;

import fr.zbar.kata.marsrover.position.Position;

public class ObstacleException extends RuntimeException {

    private final Position position;

    public ObstacleException(Position position) {
        this.position = position;
    }

    public Position position() {
        return position;
    }
}
