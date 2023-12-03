
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.programowanie.obiektowe.warehouse.Clients.ClientsImp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

@Tag("Clients")
@DisplayName("Tests for class ClientsX")
class ClientsImpTest {
    private ClientsImp testClients;
    private String clientId;
    private LocalDate testDate;

    @BeforeEach
    public void setUp() {
        testClients = new ClientsImp();
    }

    @Test
    @DisplayName("Test for adding clients")
    public void testAddClient(){
        testClients.createNewClient("Bob", "Dylan");
        Assertions.assertEquals(1, testClients.getNumberOfClients());
    }

    @Test
    @DisplayName("Test for activating premium")
    public void testActivatePremiumAccount(){
        clientId = testClients.createNewClient("Bob", "Dylan");
        Assertions.assertEquals(false, testClients.isPremiumClient(clientId));
        testClients.activatePremiumAccount(clientId);
        Assertions.assertEquals(true, testClients.isPremiumClient(clientId));
    }

    @Test
    @DisplayName("Test for geting the full name")
    public void testGetClientFullName(){
        clientId = testClients.createNewClient("Bob", "Dylan");
        Assertions.assertEquals("Bob Dylan", testClients.getClientFullName(clientId));
    }

    @Test
    @DisplayName("Test for geting creation date")
    public void testGetClientCreationDate(){
        testDate = LocalDate.now();
        clientId = testClients.createNewClient("Bob", "Dylan");
        Assertions.assertEquals(testDate, testClients.getClientCreationDate(clientId));
    }

    @Test
    @DisplayName("Test for check if premium")
    public void testIsPremiumClient(){
        clientId = testClients.createNewClient("Bob", "Dylan");
        Assertions.assertEquals(false, testClients.isPremiumClient(clientId));
    }

    @Test
    @DisplayName("Test for getting number of clients")
    public void testGetNumberOfClients(){
        Assertions.assertEquals(0, testClients.getNumberOfClients());
        testClients.createNewClient("Bob", "Dylan");
        testClients.createNewClient("Jeff", "Bezos");
        testClients.createNewClient("Jo", "Mama");
        Assertions.assertEquals(3, testClients.getNumberOfClients());
    }

    @Test
    @DisplayName("Test for getting number of premium clients")
    public void testGetNumberOfPremiumClients(){
        testClients.createNewClient("Bob", "Dylan");
        clientId = testClients.createNewClient("Jeff", "Bezos");
        testClients.createNewClient("Jo", "Mama");
        Assertions.assertEquals(3, testClients.getNumberOfClients());
        Assertions.assertEquals(0, testClients.getNumberOfPremiumClients());
        testClients.activatePremiumAccount(clientId);
        Assertions.assertEquals(3, testClients.getNumberOfClients());
        Assertions.assertEquals(1, testClients.getNumberOfPremiumClients());
    }
}
