package com.ip.model;

/**
 * This is just pojo class which contains
 * four data members.
 */
public class Persion {

    private final transient String firstName;
    private final transient String lastName;
    private final transient String gender;
    private final transient int age;

    public Persion(String firstName, String lastName, String gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("FirstName:%s LastName:%s Gender:%s Age:%s", firstName, lastName, gender, age);
    }
}
