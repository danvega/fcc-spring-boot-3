package dev.danvega.runnerz.run;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.Duration;
import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
) {

    public Run {
        if (!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed On must be after Started On");
        }
    }

    public Duration getDuration() {
        return Duration.between(startedOn,completedOn);
    }

    public Integer getAvgPace() {
        return Math.toIntExact(getDuration().toMinutes() / miles);
    }

}
