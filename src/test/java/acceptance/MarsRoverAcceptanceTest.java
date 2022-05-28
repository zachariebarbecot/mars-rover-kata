package acceptance;

import fr.zbar.kata.marsrover.*;
import fr.zbar.kata.marsrover.position.ObstaclePosition;
import fr.zbar.kata.marsrover.position.OpenPosition;
import fr.zbar.kata.marsrover.position.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverAcceptanceTest {


    @Test
    void should_move_with_no_obstacles() {
        final Grid grid = new Grid(10, 10);
        final MarsRover rover = new MarsRover(grid);
        final Command command = new Command("MMRMMLM");

        Position result = rover.execute(command);

        Position expected = new OpenPosition(new Point(2, 3), Direction.NORTH);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void should_move_with_no_obstacles_and_wrap_around() {
        final Grid grid = new Grid(10, 10);
        final MarsRover rover = new MarsRover(grid);
        final Command command = new Command("MMMMMMMMMM");

        Position result = rover.execute(command);

        Position expected = new OpenPosition(new Point(0, 0), Direction.NORTH);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void should_move_with_obstacles() {
        final Grid grid = new Grid(10, 10, new Point(0, 3));
        final MarsRover rover = new MarsRover(grid);
        final Command command = new Command("MMMM");

        Position result = rover.execute(command);

        Position expected = new ObstaclePosition(new Point(0, 2), Direction.NORTH);
        assertThat(result).isEqualTo(expected);
    }
}
