package com.capgemini.programowanie.obiektowe.warehouse.Clients;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ClientsImp implements Clients{
    protected Map<String,Client> clients;
    private int clientsNumber;
    private int premiumClientsNumber;

    public ClientsImp(){
        clients = new HashMap<>();
        clientsNumber = 0;
        premiumClientsNumber = 0;
    }
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
        throw new ClientNotFoundException();
    }

    @Override
    public String getClientFullName(String clientId) {
        if (clients.containsKey(clientId)){
            return clients.get(clientId).getFirstName() + " " + clients.get(clientId).getLastName();
        };
        throw new ClientNotFoundException();
    }

    @Override
    public LocalDate getClientCreationDate(String clientId) {
        if (clients.containsKey(clientId)){
            return clients.get(clientId).getCreateDate();
        };  
        throw new ClientNotFoundException();
    }

    @Override
    public boolean isPremiumClient(String clientId) {
        if (clients.containsKey(clientId)){
            return clients.get(clientId).getIsPremium();
        }; 
        throw new ClientNotFoundException();
    }

    @Override
    public int getNumberOfClients() {
        if(clients.isEmpty()){
            this.clientsNumber = 0;
        }else{
            this.clientsNumber = clients.size();
        }
        return this.clientsNumber;
    }

    @Override
    public int getNumberOfPremiumClients() {
        if (clients.isEmpty()) {
            this.premiumClientsNumber = 0;
        }else{
            for (Client client : clients.values()) {
                if(client.getIsPremium()){
                    this.premiumClientsNumber++;
                }
            }
        }
        return this.premiumClientsNumber;
    }
    
}
