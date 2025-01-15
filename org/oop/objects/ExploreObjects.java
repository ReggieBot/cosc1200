package org.oop.objects;

public class ExploreObjects {
    public static void main(String[] args) {
        Student s1 = new Student("10088031", "Reggie", "Brown", 20);

        System.out.println("Students first name is " + s1.getFirstName());
        System.out.println("Students last name is " + s1.getLastName());
        System.out.println("Students full name is " + s1.showFullName());
        System.out.println("Student ID = " + s1.getId());
        System.out.println("Students age is " + s1.getAge());
    }
}
