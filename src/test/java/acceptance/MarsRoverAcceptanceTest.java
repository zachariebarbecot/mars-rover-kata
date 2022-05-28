package acceptance;

import fr.zbar.kata.marsrover.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverAcceptanceTest {

    private final MarsRover rover = new MarsRover();

    @Test
    void should_move_with_no_obstacles() {
        Command command = new Command("MMRMMLM");

        Position result = rover.execute(command);

        Position expected = new Position(new Point(2, 3), Direction.NORTH);
        assertThat(result).isEqualTo(expected);
    }
}
