import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.programowanie.obiektowe.Client;
import com.capgemini.programowanie.obiektowe.ClientNotFoundException;
import com.capgemini.programowanie.obiektowe.ClientsX;
import com.capgemini.programowanie.obiektowe.SupportedMetalType;
import com.capgemini.programowanie.obiektowe.warehouse.FullWarehouseException;
import com.capgemini.programowanie.obiektowe.warehouse.ProhibitedMetalTypeException;
import com.capgemini.programowanie.obiektowe.warehouse.WarehouseImp;

public class WarehouseTest {
    private ClientsX testClients;
    private WarehouseImp testWarehouse;
    private String ClientIDBad;
    private String ClientIDGood;
    private Double amount = 0.00;
    @BeforeEach
    public void setUp() {
        testClients = new ClientsX();
        testWarehouse = new WarehouseImp();
        ClientIDBad = testClients.createNewClient("Mambo", "Jambo");
        ClientIDGood = testWarehouse.createNewClient("Moki", "Poki");
    }

    @Test
    public void testAddMetalIngot(){
        testWarehouse.addMetalIngot(ClientIDGood, SupportedMetalType.COPPER, 57);
        testWarehouse.addMetalIngot(ClientIDGood, SupportedMetalType.LEAD, 36);
        testWarehouse.addMetalIngot(ClientIDGood, SupportedMetalType.IRON, 78);
        testWarehouse.addMetalIngot(ClientIDGood, SupportedMetalType.TIN, 122);
    }

    @Test
    public void testAddMetalIngot_ClientNotFoundException(){
        assertThrows(ClientNotFoundException.class, () -> {
            testWarehouse.addMetalIngot(ClientIDBad, SupportedMetalType.IRON, 34);
        });
    }

    @Test
    public void testAddMetalIngot_ProhibitedMetalTypeException(){
        assertThrows(ProhibitedMetalTypeException.class, () -> {
            testWarehouse.addMetalIngot(ClientIDGood, SupportedMetalType.GOLD, 34);
        });
    }

    @Test
    public void testAddMetalIngot_FullWarehouseException(){
        assertThrows(FullWarehouseException.class, () -> {
            testWarehouse.addMetalIngot(ClientIDGood, SupportedMetalType.IRON, 9999);
        });
    }

    @Test
    public void testgetStoredMetalTypesByClient() {
        List<SupportedMetalType> metalList = new ArrayList<>();
        metalList.add(SupportedMetalType.COPPER);
        metalList.add(SupportedMetalType.LEAD);
        metalList.add(SupportedMetalType.IRON);
        Collections.sort(metalList); // Sort the list

        testWarehouse.addMetalIngot(ClientIDGood, SupportedMetalType.COPPER, 57);
        testWarehouse.addMetalIngot(ClientIDGood, SupportedMetalType.LEAD, 36);
        testWarehouse.addMetalIngot(ClientIDGood, SupportedMetalType.IRON, 78);

        List<SupportedMetalType> warehouseMetals = testWarehouse.getStoredMetalTypesByClient(ClientIDGood);
        Collections.sort(warehouseMetals); // Sort the list from warehouse

        assertEquals(metalList, warehouseMetals);
    }

    @Test
    public void testgetTotalVolumeOccupiedByClient() {

        testWarehouse.addMetalIngot(ClientIDGood, SupportedMetalType.COPPER, 57);
        testWarehouse.addMetalIngot(ClientIDGood, SupportedMetalType.LEAD, 36);
        testWarehouse.addMetalIngot(ClientIDGood, SupportedMetalType.IRON, 78);

        assertEquals(57+36+78, testWarehouse.getTotalVolumeOccupiedByClient(ClientIDGood));
    }

}
