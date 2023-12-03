import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.programowanie.obiektowe.SupportedMetalType;
import com.capgemini.programowanie.obiektowe.warehouse.FullWarehouseException;
import com.capgemini.programowanie.obiektowe.warehouse.ProhibitedMetalTypeException;
import com.capgemini.programowanie.obiektowe.warehouse.WarehouseImp;
import com.capgemini.programowanie.obiektowe.warehouse.Clients.ClientNotFoundException;
import com.capgemini.programowanie.obiektowe.warehouse.Clients.ClientsImp;

public class WarehouseImpTest {
    private ClientsImp testClients;
    private WarehouseImp testWarehouse;
    private String ClientIDBad;
    private String ClientIDGood;

    @BeforeEach
    public void setUp() {
        testClients = new ClientsImp();
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

    @Test
    public void testgetMetalTypesToMassStoredByClient() {
        Map<SupportedMetalType, Double> metals= new HashMap<>();
        testWarehouse.addMetalIngot(ClientIDGood, SupportedMetalType.COPPER, 57);
        metals = testWarehouse.getMetalTypesToMassStoredByClient(ClientIDGood);
        assertEquals(metals, testWarehouse.getMetalTypesToMassStoredByClient(ClientIDGood));
        testWarehouse.addMetalIngot(ClientIDGood, SupportedMetalType.LEAD, 36);
        metals = testWarehouse.getMetalTypesToMassStoredByClient(ClientIDGood);
        assertEquals(metals, testWarehouse.getMetalTypesToMassStoredByClient(ClientIDGood));
        testWarehouse.addMetalIngot(ClientIDGood, SupportedMetalType.IRON, 78);
        metals = testWarehouse.getMetalTypesToMassStoredByClient(ClientIDGood);
        assertEquals(metals, testWarehouse.getMetalTypesToMassStoredByClient(ClientIDGood));
    }

}
