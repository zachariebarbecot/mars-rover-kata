package fr.zbar.kata.marsrover.position;

import fr.zbar.kata.marsrover.Direction;
import fr.zbar.kata.marsrover.Point;

public record OpenPosition(Point point, Direction direction) implements Position {
}
