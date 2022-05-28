package acceptance;

import fr.zbar.kata.marsrover.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverAcceptanceTest {

    private final Grid grid = new Grid(10, 10);
    private final MarsRover rover = new MarsRover(grid);

    @Test
    void should_move_with_no_obstacles() {
        Command command = new Command("MMRMMLM");

        Position result = rover.execute(command);

        Position expected = new Position(new Point(2, 3), Direction.NORTH);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void should_move_with_no_obstacles_and_wrap_around() {
        Command command = new Command("MMMMMMMMMM");

        Position result = rover.execute(command);

        Position expected = new Position(new Point(0, 0), Direction.NORTH);
        assertThat(result).isEqualTo(expected);
    }
}
