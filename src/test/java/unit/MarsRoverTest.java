package unit;

import fr.zbar.kata.marsrover.*;
import fr.zbar.kata.marsrover.Direction;
import fr.zbar.kata.marsrover.position.OpenPosition;
import fr.zbar.kata.marsrover.Point;
import fr.zbar.kata.marsrover.position.Position;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverTest {

    private final Grid grid = new Grid(5, 5);
    private final MarsRover rover = new MarsRover(grid);

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

        Position expected = new OpenPosition(new Point(expectedX, expectedY), Direction.asMapByValue().get(expectedDirection));
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

        Position expected = new OpenPosition(new Point(expectedX, expectedY), Direction.asMapByValue().get(expectedDirection));
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "M,0,1,N",
            "MM,0,2,N",
            "RM,1,0,E",
            "RMM,2,0,E",
            "LM,4,0,W",
            "LMM,3,0,W",
            "LLM,0,4,S",
            "LLMM,0,3,S"
    })
    void should_move(String stringCommand, Integer expectedX, Integer expectedY, String expectedDirection) {
        Command command = new Command(stringCommand);

        Position result = rover.execute(command);

        Position expected = new OpenPosition(new Point(expectedX, expectedY), Direction.asMapByValue().get(expectedDirection));
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "MMMMM,0,0,N",
            "RMMMMM,0,0,E",
            "LM,4,0,W",
            "LLM,0,4,S",
    })
    void should_wrap_around(String stringCommand, Integer expectedX, Integer expectedY, String expectedDirection) {
        Command command = new Command(stringCommand);

        Position result = rover.execute(command);

        Position expected = new OpenPosition(new Point(expectedX, expectedY), Direction.asMapByValue().get(expectedDirection));
        assertThat(result).isEqualTo(expected);
    }
}
