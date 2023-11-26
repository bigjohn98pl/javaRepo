package com.capgemini.programowanie.obiektowe.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.programowanie.obiektowe.ClientNotFoundException;
import com.capgemini.programowanie.obiektowe.ClientsX;
import com.capgemini.programowanie.obiektowe.SupportedMetalType;

public class WarehouseImp extends ClientsX implements Warehouse {
    private Map<String, Map<SupportedMetalType, Double>> storage;
    private double maxStorage;

    public WarehouseImp(){
        storage = new HashMap<>();
        maxStorage = 1000.00;
    }

    public void addMetalIngot(String clientId, SupportedMetalType metalType, double mass)
        throws ClientNotFoundException, ProhibitedMetalTypeException, FullWarehouseException {
        if (!clients.containsKey(clientId)) {
            throw new ClientNotFoundException("Client not found: " + clientId);
        }

        if (!this.isPremiumClient(clientId) && "GOLD".equals(metalType.name())) {
            throw new ProhibitedMetalTypeException("Non-premium clients cannot store GOLD.");
        }

        double newTotalMass = mass;
        if (storage.containsKey(clientId)) {
            newTotalMass += storage.get(clientId).getOrDefault(metalType, 0.0);
        }

        if ((maxStorage - newTotalMass) < 0.00) {
            throw new FullWarehouseException("Adding this mass would exceed the warehouse capacity.");
        }

        storage.computeIfAbsent(clientId, k -> new HashMap<>()).put(metalType, newTotalMass);
        maxStorage -= mass;
    }

    @Override
    public Map<SupportedMetalType, Double> getMetalTypesToMassStoredByClient(String clientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMetalTypesToMassStoredByClient'");
    }

    @Override
    public double getTotalVolumeOccupiedByClient(String clientId) {
        double volume = 0.00;
        for (double mass : storage.get(clientId).values()) {
            volume += mass;
        }
        return volume;
    }

    @Override
    public List<SupportedMetalType> getStoredMetalTypesByClient(String clientId) {
        List<SupportedMetalType> metalList = new ArrayList<>();
        for (SupportedMetalType supportedMetalType : storage.get(clientId).keySet()) {
            metalList.add(supportedMetalType);
        }
        return metalList;
    }
    
}
