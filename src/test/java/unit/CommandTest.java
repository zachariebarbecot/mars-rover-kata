package unit;

import fr.zbar.kata.marsrover.Command;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandTest {

    @Test
    void should_throw_exception_when_command_is_empty() {
        Assertions.assertThatThrownBy(() -> new Command(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("command can not be empty or blank");
    }

    @Test
    void should_throw_exception_when_command_is_blank() {
        Assertions.assertThatThrownBy(() -> new Command(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("command can not be empty or blank");
    }
}
