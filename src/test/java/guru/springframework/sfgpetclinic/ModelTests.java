package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("models")
public interface ModelTests {
    @BeforeAll
    default void beforeAll() {
        System.out.println("Before everything...");
    }

    @BeforeEach
    default void beforeEach(TestInfo testInfo) {
        System.out.println("Before each - " + testInfo.getDisplayName());
    }
}
