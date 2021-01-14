package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

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