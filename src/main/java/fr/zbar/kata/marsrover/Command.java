package fr.zbar.kata.marsrover;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.Stream;

public record Command(String value) {

    public Command {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException("command can not be empty or blank");
        }
    }

    public Stream<String> stream() {
        return Arrays.stream(value.split(""));
    }
}
