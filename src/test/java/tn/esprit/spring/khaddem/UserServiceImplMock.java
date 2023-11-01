package tn.esprit.spring.khaddem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.khaddem.entities.*;
import tn.esprit.spring.khaddem.repositories.EtudiantRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceImplMock {


    @Mock
    EtudiantRepository etudiantRepository;
    // Ou
    //UserRepository userRepository = Mockito.mock(UserRepository.class);

    @InjectMocks
    EtudiantImplTest etudiantImplTest;

    Etudiant etudiant = new Etudiant("f1","l1",new Date(),Option.GAMIX);
    List<Etudiant> listEtudiants = new ArrayList<Etudiant>() {
        {
            add(new Etudiant("f2", "l2", new Date(), Option.GAMIX));
            add(new Etudiant("f3", "l3", new Date(), Option.GAMIX));
        }
    };

    @Test
    public void testRetrieveEtudiant() {

        Mockito.when(etudiantRepository.findById((int) Mockito.anyLong())).thenReturn(Optional.of(etudiant))
        ;
        Etudiant etudiant1 = etudiantImplTest.us.retrieveEtudiant(2);
        Assertions.assertNotNull(etudiant1);
    }



}
