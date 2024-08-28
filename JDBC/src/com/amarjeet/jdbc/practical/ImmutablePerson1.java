package com.amarjeet.jdbc.practical;

final public class ImmutablePerson1 {

    // Private and final fields
    private final String name;
    private final int age;

    // Constructor that initializes all fields
    public ImmutablePerson1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // No setter methods provided

    // Only getter methods to access the fields
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Main method to demonstrate the use of ImmutablePerson class
    public static void main(String[] args) {
        // Creating an immutable person object
        ImmutablePerson1 person = new ImmutablePerson1("Amarjeet", 23);

        // Accessing the fields using getter methods
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());

        // The following lines are commented out to show that setting values is not possible
        // person.setName("John");  // This line would cause a compilation error
        // person.setAge(30);       // This line would cause a compilation error
    }
}
