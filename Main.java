package Program3;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Parent class
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    void displayName() {
        System.out.println("Name: " + name);
    }

    void displayAge(String dobStr) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date dob = format.parse(dobStr);
            Date today = new Date();

            long ageInMillis = today.getTime() - dob.getTime();
            long age = ageInMillis / (1000L * 60 * 60 * 24 * 365); // approx

            System.out.println("Age: " + age + " years");
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use DD-MM-YYYY.");
        }
    }
}

// Child class
class Employee extends Person {
    int empId;
    double salary;

    Employee(String name, int empId, double salary) {
        super(name); // call to Person constructor
        this.empId = empId;
        this.salary = salary;
    }

    void displayEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: " + salary);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter date of birth (DD-MM-YYYY): ");
        String dob = sc.nextLine();

        System.out.print("Enter employee ID: ");
        int empId = sc.nextInt();

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(name, empId, salary);
        emp.displayName();
        emp.displayAge(dob);
        emp.displayEmployeeDetails();

        sc.close();
    }
}
