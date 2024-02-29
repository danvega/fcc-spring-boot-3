package dev.danvega.runnerz.run;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RunControllerIntTest {

    @LocalServerPort
    int randomServerPort;

    RestClient restClient;

    @BeforeEach
    void setUp() {
        restClient = RestClient.create("http://localhost:" + randomServerPort);
    }

    @Test
    void shouldFindAllRuns() {
        List<Run> runs = restClient.get()
                        .uri("/api/runs")
                        .retrieve()
                        .body(new ParameterizedTypeReference<>() {});
        assertEquals(10, runs.size());
    }

    @Test
    void shouldFindRunById() {
        Run run = restClient.get()
                .uri("/api/runs/1")
                .retrieve()
                .body(Run.class);

        assertAll(
                () -> assertEquals(1, run.id()),
                () -> assertEquals("Noon Run", run.title()),
                () -> assertEquals("2024-02-20T06:05", run.startedOn().toString()),
                () -> assertEquals("2024-02-20T10:27", run.completedOn().toString()),
                () -> assertEquals(24, run.miles()),
                () -> assertEquals(Location.INDOOR, run.location()));
    }

    @Test
    void shouldCreateNewRun() {
        Run run = new Run(11, "Evening Run", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 10, Location.OUTDOOR);

        ResponseEntity<Void> newRun = restClient.post()
                .uri("/api/runs")
                .body(run)
                .retrieve()
                .toBodilessEntity();

        assertEquals(201, newRun.getStatusCodeValue());
    }

    @Test
    void shouldUpdateExistingRun() {
        Run run = restClient.get().uri("/api/runs/1").retrieve().body(Run.class);

        ResponseEntity<Void> updatedRun = restClient.put()
                .uri("/api/runs/1")
                .body(run)
                .retrieve()
                .toBodilessEntity();

        assertEquals(204, updatedRun.getStatusCodeValue());
    }

    @Test
    void shouldDeleteRun() {
        ResponseEntity<Void> run = restClient.delete()
                .uri("/api/runs/1")
                .retrieve()
                .toBodilessEntity();

        assertEquals(204, run.getStatusCodeValue());
    }

}