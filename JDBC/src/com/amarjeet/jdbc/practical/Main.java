package com.amarjeet.jdbc.practical;

public class Main {
    public static void main(String[] args) {
        // Create a mutable Address object
        Address address = new Address("123 Main St", "Springfield");

        // Create an ImmutablePerson object with the mutable Address
        ImmutablePerson1 person = new ImmutablePerson1("John Doe", 30, address);

        // Access and print the details using getter methods
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Address: " + person.getAddress().getStreet() + ", " + person.getAddress().getCity());

        // Modify the original Address object
        address.setStreet("456 Elm St");
        address.setCity("Metropolis");

        // Print the details again to show that ImmutablePerson remains unchanged
        System.out.println("\nAfter modifying the original Address object:");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Address: " + person.getAddress().getStreet() + ", " + person.getAddress().getCity());
    }
}


// A mutable class example (used in the ImmutablePerson class)
class Address {
    private String street;
    private String city;

    // Constructor
    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    // Getters and setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
