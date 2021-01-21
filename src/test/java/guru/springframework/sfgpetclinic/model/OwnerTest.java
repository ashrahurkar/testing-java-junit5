package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1L,"Ashish","R");
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

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring","Framework","Good"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void testEnumSource(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @DisplayName("CSV Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL, 1, 1",
            "OH, 2, 4",
            "MI, 2, 7"
    })
    void testCSVSource(String state, int val1, int val2) {
        System.out.println(state + " - " + val1 + " " + val2);
    }

    @DisplayName("CSV File Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void testCSVFileSource(String state, int val1, int val2) {
        System.out.println(state + " - " + val1 + " " + val2);
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void testFromMethod(String state, int val1, int val2) {
        System.out.println(state + " - " + val1 + " " + val2);
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of("FL", 1, 1),
                Arguments.of("OH", 2, 4),
                Arguments.of("MI", 2, 7));
    }

    @DisplayName("Custom Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void testFromCustomProvider(String state, int val1, int val2) {
        System.out.println(state + " - " + val1 + " " + val2);
    }
}