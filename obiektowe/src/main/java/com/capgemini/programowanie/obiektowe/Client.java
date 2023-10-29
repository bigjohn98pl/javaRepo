package com.capgemini.programowanie.obiektowe;

import java.time.LocalDate;
import java.util.UUID;

import org.omg.CORBA.Object;

public class Client{
    private String firstName;
    private String lastName;
    private UUID id;
    private LocalDate createDate;
    private boolean isPremium;
    
    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = UUID.randomUUID();
        this.createDate = LocalDate.now();
        this.isPremium = false;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id.hashCode();
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setIsPremium(boolean setValue){
        this.isPremium = setValue;
    }

    public boolean getIsPremium(){
        return this.isPremium;
    }

    public void show(){
        System.out.println("Name: " + this.firstName);
        System.out.println("LastName: " + this.lastName);
        System.out.println("ID: " + this.id);
        System.out.println("Creation Date: " + this.createDate);
    }

    public boolean equals(Client obj){
        if(this.getId() == obj.getId()){
            return true;
        }else{
            return false;
        }
    }
}
