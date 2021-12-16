package com.bestelling.bestelling.infrastructure.driver.event;

import lombok.AllArgsConstructor;
import lombok.Data;

//@AllArgsConstructor @Data
public class UserDTO {

    private String id;
    private String firstName;
    private String lastName;
    private Address address;

    public UserDTO(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}