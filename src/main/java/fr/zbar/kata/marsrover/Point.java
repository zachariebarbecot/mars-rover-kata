package fr.zbar.kata.marsrover;

public record Point(Integer x, Integer y) {
    public static final Point INIT = new Point(0, 0);
}
