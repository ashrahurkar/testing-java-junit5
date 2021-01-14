package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1l,"Ashish","R");
        owner.setCity("Pune");
        owner.setTelephone("12342534");

        assertAll("Properties Test : ",
                () -> assertAll("Person Properties : ",
                            () -> assertEquals("Ashish", owner.getFirstName(),"First Name did not match"),
                            () -> assertEquals("R", owner.getLastName(),"Last Name did not match")),
                () -> assertAll("Owner Properties : ",
                        () -> assertEquals("Pune", owner.getCity(),"City did not match"),
                        () -> assertEquals("12342534", owner.getTelephone(),"Telephone did not match"))
                );
    }
}