package dev.danvega.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
class RunRepository {

    private static final Logger log = LoggerFactory.getLogger(RunRepository.class);
    private final List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return Optional.ofNullable(runs.stream().filter(run -> run.id() == id).findFirst().orElseThrow(RuntimeException::new));
    }

    public Run create(Run run) {
        Run newRun = new Run(run.id(),
                run.title(),
                run.startedOn(),
                run.completedOn(),
                run.miles(),
                run.location());

        runs.add(newRun);
        return newRun;
    }

    void update(Run newRun, Integer id) {
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()) {
            var r = existingRun.get();
            log.info("Updating Existing Run: " + existingRun.get());
            runs.set(runs.indexOf(r),newRun);
        }
    }

    void delete(Integer id) {
        runs.removeIf(run -> Objects.equals(run.id(), id));
    }

    int count() {
        return runs.size();
    }

    public void saveAll(List<Run> runs) {
        runs.stream().forEach(run -> create(run));
    }


    @PostConstruct
    private void init() {
//        runs.add(new Run(1,
//                "Monday Morning Run",
//                LocalDateTime.now(),
//                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
//                3,
//                Location.INDOOR));
//
//        runs.add(new Run(2,
//                "Wednesday Evening Run",
//                LocalDateTime.now(),
//                LocalDateTime.now().plus(60, ChronoUnit.MINUTES),
//                6,
//                Location.INDOOR));
    }


}
