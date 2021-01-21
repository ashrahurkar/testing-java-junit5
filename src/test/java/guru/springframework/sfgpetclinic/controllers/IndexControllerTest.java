package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllerTests {

    private IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Just a sample test")
    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(),() -> "Expensive " +
                "Message");
        assertThat(indexController.index()).isEqualTo("index");
    }

    @Test
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            indexController.oopsHandler();
        });
    }

    @Disabled
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here");
        });
    }

    @Disabled
    @Test
    void testTimeoutPreempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here 2342345rt23");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("PROD".equalsIgnoreCase(System.getenv("PROD_RUNTIME")));
        // it doesn't fail the test but ignores the test when fails
    }

    @Test
    void testAssumptionIsTrue() {
        assumeTrue("PROD".equalsIgnoreCase("PROD"));
    }

    @EnabledOnOs(OS.LINUX)
    @Test
    void testLinux() {

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testWindows() {

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testJava8() {

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testJava11() { 

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "guest")
    @Test
    void testIfUserGuest() {

    }
}