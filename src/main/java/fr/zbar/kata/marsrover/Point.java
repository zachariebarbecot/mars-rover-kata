package fr.zbar.kata.marsrover;

public record Point(Integer x, Integer y) {
    public static final Point INIT = new Point(0, 0);

    public Boolean isXEqual(Integer value) {
        return x.equals(value);
    }

    public Boolean isYEqual(Integer value) {
        return y.equals(value);
    }
}
