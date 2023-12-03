package com.capgemini.programowanie.obiektowe.warehouse.Clients;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException() {
    }

    public ClientNotFoundException(String string) {
        super(string);
    }
}
