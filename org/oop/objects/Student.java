package org.oop.objects;

import java.util.Formatter;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private int age;

    public Student(String id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // getter methods
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}

