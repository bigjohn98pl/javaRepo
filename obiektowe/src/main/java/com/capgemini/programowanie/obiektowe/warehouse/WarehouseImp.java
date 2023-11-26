package com.capgemini.programowanie.obiektowe.warehouse;

import java.util.List;
import java.util.Map;

import com.capgemini.programowanie.obiektowe.ClientNotFoundException;

public class WarehouseImp implements Warehouse {

    @Override
    public void addMetalIngot(String clientId, SupportedMetalType metalType, double mass)
            throws ClientNotFoundException, ProhibitedMetalTypeException, FullWarehouseException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addMetalIngot'");
    }

    @Override
    public Map<SupportedMetalType, Double> getMetalTypesToMassStoredByClient(String clientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMetalTypesToMassStoredByClient'");
    }

    @Override
    public double getTotalVolumeOccupiedByClient(String clientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTotalVolumeOccupiedByClient'");
    }

    @Override
    public List<SupportedMetalType> getStoredMetalTypesByClient(String clientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStoredMetalTypesByClient'");
    }
    
}
