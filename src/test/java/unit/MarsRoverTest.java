package unit;

import fr.zbar.kata.marsrover.*;
import fr.zbar.kata.marsrover.position.ObstaclePosition;
import fr.zbar.kata.marsrover.position.OpenPosition;
import fr.zbar.kata.marsrover.position.Position;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverTest {

    @ParameterizedTest
    @CsvSource({
            "L,0,0,W",
            "LL,0,0,S",
            "LLL,0,0,E",
            "LLLL,0,0,N"
    })
    void should_rotate_to_the_left(String stringCommand, Integer expectedX, Integer expectedY, String expectedDirection) {
        final Grid grid = new Grid(5, 5);
        final MarsRover rover = new MarsRover(grid);
        final Command command = new Command(stringCommand);

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
        final Grid grid = new Grid(5, 5);
        final MarsRover rover = new MarsRover(grid);
        final Command command = new Command(stringCommand);

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
        final Grid grid = new Grid(5, 5);
        final MarsRover rover = new MarsRover(grid);
        final Command command = new Command(stringCommand);

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
        final Grid grid = new Grid(5, 5);
        final MarsRover rover = new MarsRover(grid);
        final Command command = new Command(stringCommand);

        Position result = rover.execute(command);

        Position expected = new OpenPosition(new Point(expectedX, expectedY), Direction.asMapByValue().get(expectedDirection));
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "0,2,MM,0,1,N",
            "0,2,MMM,0,1,N",
            "0,2,MMMM,0,1,N",
            "0,1,RMLMLM,1,1,W",
            "0,1,RMLMLMM ,1,1,W",
            "0,3,MLMRMMRM,4,3,E",
            "0,3,MLMRMMRMM,4,3,E",
            "2,0,RMM,1,0,E"
    })
    void should_move_to_obstacle(Integer obstacleX, Integer obstacleY, String stringCommand, Integer expectedX, Integer expectedY, String expectedDirection) {
        final Point obstacle = new Point(obstacleX, obstacleY);
        final Grid grid = new Grid(5, 5, obstacle);
        final MarsRover rover = new MarsRover(grid);
        final Command command = new Command(stringCommand);

        Position result = rover.execute(command);

        Position expected = new ObstaclePosition(new Point(expectedX, expectedY), Direction.asMapByValue().get(expectedDirection));
        assertThat(result).isEqualTo(expected);
    }
}
