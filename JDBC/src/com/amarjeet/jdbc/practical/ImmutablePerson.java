package com.amarjeet.jdbc.practical;

//ImmutablePerson class
final public class ImmutablePerson {
 // Private and final fields
 private final String name;
 private final int age;
 private final Address address;  // Assume Address is a mutable class

 // Constructor that initializes all fields
 public ImmutablePerson(String name, int age, Address address) {
     this.name = name;
     this.age = age;
     // Perform deep copy to avoid external modifications
     this.address = new Address(address.getStreet(), address.getCity());
 }

 // No setter methods provided

 // Only getter methods to access the fields
 public String getName() {
     return name;
 }

 public int getAge() {
     return age;
 }

 // Return a copy of the mutable object to ensure immutability
 public Address getAddress() {
     return new Address(address.getStreet(), address.getCity());
 }
}
