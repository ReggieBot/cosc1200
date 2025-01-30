package Assignment1;

public class Main {
    public static void main(String[] args) {
        // Creating student objects
        Student student1 = new Student("Reggie", 20, "100883021");
        Student student2 = new Student("Ben", 22, "100883021");

        // Testing getter and setter methods
        student2.setName("Benjamin");

        // Displaying student details
        student1.displayDetails();
        student2.displayDetails();

        // Testing static getter and setter methods
        System.out.println("College Name: " + Student.getCollegeName());
        Student.setCollegeName("OTU");
        System.out.println("College Name: " + Student.getCollegeName());
    }
    
}
