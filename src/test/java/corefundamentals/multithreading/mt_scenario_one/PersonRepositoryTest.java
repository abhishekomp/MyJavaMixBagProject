package corefundamentals.multithreading.mt_scenario_one;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryTest {

    static final LinkedHashSet<Person> PERSONS = new LinkedHashSet<>();
    ExecutorService executorService;
    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        PERSONS.clear();
        personRepository = new PersonRepository(PERSONS);
        executorService = Executors.newFixedThreadPool(3);
        System.out.println("Executor Created");
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        executorService.shutdown();
        awaitTerminationAndShutdownNow();
    }

    @RepeatedTest(15)
    void shouldPersistPersonCorrectlyWithMultipleThreads() throws InterruptedException {
        persistManyPersonsConcurrently(15);
        awaitTerminationAndShutdownNow();
        assertEquals(10, PERSONS.size());
    }

    @Test
    void shouldPerformThePersistenceOfPersonsWithinTheGivenTimeout() {
        assertTimeout(Duration.ofSeconds(1), () -> persistManyPersonsConcurrently(20));
    }

    private List<Person> persistManyPersonsConcurrently(int numberOfPersons) {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < numberOfPersons; i++) {
            final int indexCopy = i;
            executorService.submit(() -> personRepository.persist(new Person("Person n: " + indexCopy)));
        }
        return personList;
    }

    private void awaitTerminationAndShutdownNow() throws InterruptedException {
        boolean timeout = executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
        if (timeout) {
            executorService.shutdownNow();
        }
    }
}