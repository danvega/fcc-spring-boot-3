package dev.danvega.runnerz.run;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@JdbcTest
@Import(JdbcRunRepository.class)
// @AutoConfigureTestDatabase(replace=Replace.NONE)
class JdbcRunRepositoryTest {

    @Autowired
    JdbcRunRepository repository;

    @BeforeEach
    void setUp() {
        repository.create(new Run(1,
                "Monday Morning Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                3,
                Location.INDOOR));

        repository.create(new Run(2,
                "Wednesday Evening Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(60, ChronoUnit.MINUTES),
                6,
                Location.INDOOR));
    }

    @Test
    void shouldFindAllRuns() {
        List<Run> runs = repository.findAll();
        assertEquals(2, runs.size());
    }

    @Test
    void shouldFindRunWithValidId() {
        var run = repository.findById(1).get();
        assertEquals("Monday Morning Run", run.title());
        assertEquals(3, run.miles());
    }

    @Test
    void shouldNotFindRunWithInvalidId() {
        var run = repository.findById(3);
        assertTrue(run.isEmpty());
    }

    @Test
    void shouldCreateNewRun() {
        repository.create(new Run(3,
                "Friday Morning Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                3,
                Location.INDOOR));
        List<Run> runs = repository.findAll();
        assertEquals(3, runs.size());
    }

    @Test
    void shouldUpdateRun() {
        repository.update(new Run(1,
                "Monday Morning Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                5,
                Location.OUTDOOR), 1);
        var run = repository.findById(1).get();
        assertEquals("Monday Morning Run", run.title());
        assertEquals(5, run.miles());
        assertEquals(Location.OUTDOOR, run.location());
    }

    @Test
    void shouldDeleteRun() {
        repository.delete(1);
        List<Run> runs = repository.findAll();
        assertEquals(1, runs.size());
    }

}