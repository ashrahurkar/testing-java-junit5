package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1L,"Ashish","R");
        // then
        assertAll("Test props set",
                () -> assertEquals("Ashish",person.getFirstName()),
                () -> assertEquals("R",person.getLastName(),"Last Name failed"));
    }
}