import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import com.capgemini.programowanie.obiektowe.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class ClientTest {
    
    private Client client;
    private Client client2;
    private LocalDate testDate;

    @BeforeEach
    public void setUp() {
        client = new Client("Jan", "Dzban");
        client2 = new Client("Janek", "Dzbanek");
    }

    @Test
    public void testName() {
        Assertions.assertEquals("Jan", client.getName());
    }

    @Test
    public void testLastName() {
        Assertions.assertEquals("Dzban", client.getLastName());
    }

    @Test
    public void testIDs() {
        Assertions.assertNotEquals(client.getId(), client2.getId());
    }

    @Test
    public void testIsPremium() {
        Assertions.assertEquals(false, client.getIsPremium());
        client.setIsPremium(true);
        Assertions.assertNotEquals(true, client.getId());
    }

    @Test
    public void testGetCreationDate() {
        testDate = LocalDate.now();
        Assertions.assertEquals(testDate, client.getCreateDate());
        testDate = LocalDate.of(1998, 5, 14);
        Assertions.assertNotEquals(testDate, client.getCreateDate());
    }
}