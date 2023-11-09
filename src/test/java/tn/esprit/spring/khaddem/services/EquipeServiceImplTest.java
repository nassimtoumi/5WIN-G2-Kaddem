package tn.esprit.spring.khaddem.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.khaddem.entities.Equipe;
import tn.esprit.spring.khaddem.entities.Niveau;
import tn.esprit.spring.khaddem.repositories.EquipeRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EquipeServiceImplTest {

    @Mock
    EquipeRepository equipeRepository;

    @InjectMocks
    EquipeServiceImpl equipeService;

    Equipe equipe = new Equipe(1, "Equipe1", Niveau.JUNIOR);
    List<Equipe> equipeList = Arrays.asList(
            new Equipe(1, "Equipe1", Niveau.SENIOR),
            new Equipe(2, "Equipe2", Niveau.EXPERT)
    );

    @Test
    void testRetrieveEquipe() {
        Mockito.when(equipeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(equipe));

        Equipe retrievedEquipe = equipeService.retrieveEquipe(1);

        Assertions.assertNotNull(retrievedEquipe);
        Assertions.assertEquals(equipe, retrievedEquipe);

        // Print the actual and expected values to the console
        System.out.println("Actual: " + retrievedEquipe);
        System.out.println("Expected: " + equipe);
    }

    @Test
    void testRetrieveAllEquipes() {
        Mockito.when(equipeRepository.findAll()).thenReturn(equipeList);

        List<Equipe> retrievedEquipes = equipeService.retrieveAllEquipes();

        Assertions.assertNotNull(retrievedEquipes);
        Assertions.assertEquals(equipeList, retrievedEquipes);

        // Print the actual and expected values to the console
        System.out.println("Actual: " + retrievedEquipes);
        System.out.println("Expected: " + equipeList);
    }

    @Test
    void testAddEquipe() {
        Mockito.when(equipeRepository.save(equipe)).thenReturn(equipe);

        Equipe addedEquipe = equipeService.addEquipe(equipe);

        Assertions.assertNotNull(addedEquipe);
        Assertions.assertEquals(equipe, addedEquipe);

        // Print the actual and expected values to the console
        System.out.println("Actual: " + addedEquipe);
        System.out.println("Expected: " + equipe);
    }
}
