package com.capgemini.programowanie.obiektowe;

import com.capgemini.programowanie.obiektowe.warehouse.Clients.Client;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Client client1 = new Client("Januesz", "Zychal");
        
        client1.show();

    }
}