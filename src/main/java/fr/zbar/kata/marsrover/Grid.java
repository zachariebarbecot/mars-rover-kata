package fr.zbar.kata.marsrover;

import java.util.Arrays;

public record Grid(Integer maxX, Integer maxY, Point... obstacles) {

    public Boolean isObstacle(Point point) {
        return Arrays.asList(obstacles).contains(point);
    }
}
