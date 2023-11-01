package tn.esprit.spring.khaddem;




import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
        import org.junit.jupiter.api.Order;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.khaddem.entities.Etudiant;
import tn.esprit.spring.khaddem.entities.Option;
import tn.esprit.spring.khaddem.services.IEtudiantService;;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EtudiantImplTest {
    @Autowired
    IEtudiantService us;
    @Test
    @Order(1)
    public void testRetrieveAllUsers() {
        List<Etudiant> listUsers = us.retrieveAllEtudiants();
        Assertions.assertEquals(0, listUsers.size());
    }

}