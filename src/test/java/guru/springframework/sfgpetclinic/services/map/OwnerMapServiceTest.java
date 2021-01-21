package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Owner Map service Test -")
class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;
    private PetTypeService petTypeService;
    private PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService,petService);

        System.out.println("OwnerMapServiceTest before each...");
    }

    @DisplayName("verify zero owners")
    @Test
    void ownersAreZero() {
        int ownerCnt = ownerMapService.findAll().size();
        assertThat(ownerCnt).isZero();
    }

    @DisplayName("Pet Type-")
    @Nested
    class TestCreatePetTypes {
        @BeforeEach
        void setUp() {
            PetType petType = new PetType("Dog");
            PetType petType2 = new PetType("Cat");

            petTypeService.save(petType);
            petTypeService.save(petType2);

            System.out.println("TestCreatePetTypes before each...");
        }

        @Test
        void testPetCount() {
            int petCnt = petTypeService.findAll().size();

            assertThat(petCnt).isNotZero().isEqualTo(2);
        }

        @DisplayName("Save owner tests -")
        @Nested
        class SaveOwnersTests {

            @BeforeEach
            void setUp() {
                Owner owner1 = new Owner(1L,"Ashish","R");
                Owner owner2 = new Owner(2L,"Jay","Jawan");

                ownerMapService.save(owner1);
                ownerMapService.save(owner2);

                System.out.println("SaveOwnersTests before each...");
            }

            @Test
            void testOwnerCount() {
                assertThat(ownerMapService.findAll()).isNotNull();
            }

            @DisplayName("Save owner tests -")
            @Nested
            class FindOwnersTests {
                @DisplayName("Find owner")
                @Test
                void findOwner() {
                    Owner owner = ownerMapService.findById(1L);
                    assertThat(owner).isNotNull();
                }

                @DisplayName("Find owner not exists")
                @Test
                void findOwnerNotFound() {
                    Owner owner = ownerMapService.findById(3L);
                    assertThat(owner).isNull();
                }
            }
        }
    }

    @DisplayName("verify zero owners again")
    @Test
    void ownersAreStillZero() {
        int ownerCnt = ownerMapService.findAll().size();
        assertThat(ownerCnt).isZero();
    }
}