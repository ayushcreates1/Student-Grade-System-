import java.util.Scanner;

class Student {

    int rollNumber;
    String name;
    double marks1;
    double marks2;
    double marks3;
    double marks4;
    double marks5;

    Student(int rollNumber, String name,
            double marks1, double marks2, double marks3,
            double marks4, double marks5) {

        this.rollNumber = rollNumber;
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
        this.marks4 = marks4;
        this.marks5 = marks5;
    }

    // Calculate Total Marks
    double calculateTotal() {
        return marks1 + marks2 + marks3 + marks4 + marks5;
    }

    // Calculate Percentage
    double calculatePercentage() {
        return calculateTotal() / 5;
    }

    // Calculate Grade
    String calculateGrade() {

        double percentage = calculatePercentage();

        if (percentage >= 90) {
            return "A+";
        } 
        else if (percentage >= 80) {
            return "A";
        } 
        else if (percentage >= 70) {
            return "B";
        } 
        else if (percentage >= 60) {
            return "C";
        } 
        else if (percentage >= 50) {
            return "D";
        } 
        else if (percentage >= 40) {
            return "E";
        } 
        else {
            return "F";
        }
    }

    // Check Pass or Fail
    String getResult() {

        if (marks1 >= 33 &&
            marks2 >= 33 &&
            marks3 >= 33 &&
            marks4 >= 33 &&
            marks5 >= 33) {

            return "PASS";
        } 
        else {
            return "FAIL";
        }
    }

    // Display Student Details
    void displayStudent() {

        System.out.println("\n================================");
        System.out.println("        STUDENT DETAILS");
        System.out.println("================================");

        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Name        : " + name);

        System.out.println("--------------------------------");
        System.out.println("Subject 1   : " + marks1);
        System.out.println("Subject 2   : " + marks2);
        System.out.println("Subject 3   : " + marks3);
        System.out.println("Subject 4   : " + marks4);
        System.out.println("Subject 5   : " + marks5);

        System.out.println("--------------------------------");
        System.out.println("Total       : " + calculateTotal());
        System.out.println("Percentage  : " + calculatePercentage() + "%");
        System.out.println("Grade       : " + calculateGrade());
        System.out.println("Result      : " + getResult());

        System.out.println("================================");
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);

    static Student student = null;

    // Add Student
    static void addStudent() {

        if (student != null) {
            System.out.println("Student record already exists!");
            return;
        }

        System.out.print("Enter Roll Number: ");
        int rollNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        double marks1 = getMarks("Subject 1");
        double marks2 = getMarks("Subject 2");
        double marks3 = getMarks("Subject 3");
        double marks4 = getMarks("Subject 4");
        double marks5 = getMarks("Subject 5");

        student = new Student(
                rollNumber,
                name,
                marks1,
                marks2,
                marks3,
                marks4,
                marks5
        );

        System.out.println("\nStudent added successfully!");
    }

    // Get Valid Marks
    static double getMarks(String subject) {

        double marks;

        while (true) {

            System.out.print("Enter marks for " + subject + " (0-100): ");
            marks = sc.nextDouble();

            if (marks >= 0 && marks <= 100) {
                return marks;
            }

            System.out.println("Invalid marks!");
            System.out.println("Please enter marks between 0 and 100.");
        }
    }

    // View Student
    static void viewStudent() {

        if (student == null) {
            System.out.println("No student record found!");
        } 
        else {
            student.displayStudent();
        }
    }

    // Main Method
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("       STUDENT GRADE SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudent();
                    break;

                case 3:
                    System.out.println(
                        "Thank you for using Student Grade System!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Please enter 1, 2 or 3."
                    );
            }

        } while (choice != 3);

        sc.close();
    }
}