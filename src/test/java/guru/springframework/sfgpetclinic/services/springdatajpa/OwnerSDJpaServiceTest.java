package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Disabled(value = "Disabled until we learn mocking")
class OwnerSDJpaServiceTest {

    private OwnerSDJpaService ownerSDJpaService;

    @BeforeEach
    void setUp() {
        ownerSDJpaService = new OwnerSDJpaService(null,null,null);
    }


    @Test
    void findByLastName() {
        Owner owner = ownerSDJpaService.findByLastName("R");
    }

    @Test
    void findAllByLastNameLike() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}