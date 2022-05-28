package unit;

import fr.zbar.kata.marsrover.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverTest {

    private final MarsRover rover = new MarsRover();

    @ParameterizedTest
    @CsvSource({
            "L,0,0,W",
            "LL,0,0,S",
            "LLL,0,0,E",
            "LLLL,0,0,N"
    })
    void should_rotate_to_the_left(String stringCommand, Integer expectedX, Integer expectedY, String expectedDirection) {
        Command command = new Command(stringCommand);

        Position result = rover.execute(command);

        Position expected = new Position(new Point(expectedX, expectedY), Direction.asMapByValue().get(expectedDirection));
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "R,0,0,E",
            "RR,0,0,S",
            "RRR,0,0,W",
            "RRRR,0,0,N"
    })
    void should_rotate_to_the_right(String stringCommand, Integer expectedX, Integer expectedY, String expectedDirection) {
        Command command = new Command(stringCommand);

        Position result = rover.execute(command);

        Position expected = new Position(new Point(expectedX, expectedY), Direction.asMapByValue().get(expectedDirection));
        assertThat(result).isEqualTo(expected);
    }
}
