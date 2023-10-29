package com.capgemini.programowanie.obiektowe;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ClientsX implements Clients{
    private Map<String,Client> clients;
    @Override
    public String createNewClient(String firstName, String lastName) {
        Client newClient = new Client(firstName, lastName);
        clients.put(newClient.getId(), newClient);
        return newClient.getId();
    }

    @Override
    public String activatePremiumAccount(String clientId) {
        if (clients.containsKey(clientId)){
            clients.get(clientId).setIsPremium(true);
            return clientId;
        };
        return "Client not found!";
    }

    @Override
    public String getClientFullName(String clientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClientFullName'");
    }

    @Override
    public LocalDate getClientCreationDate(String clientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClientCreationDate'");
    }

    @Override
    public boolean isPremiumClient(String clientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isPremiumClient'");
    }

    @Override
    public int getNumberOfClients() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumberOfClients'");
    }

    @Override
    public int getNumberOfPremiumClients() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumberOfPremiumClients'");
    }
    
}
