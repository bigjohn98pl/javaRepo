import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.programowanie.obiektowe.warehouse.Clients.Client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

@Tag("Clients")
@DisplayName("Tests for class Client")
class ClientTest {
    
    private Client client;
    private Client client2;
    private LocalDate testDate;

    @BeforeEach
    public void setUp() {
        client = new Client("Jan", "Dzban");
        client2 = new Client("Janek", "Dzbanek");
    }

    @Test
    public void testFirstName() {
        Assertions.assertEquals("Jan", client.getFirstName());
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