package Program3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
            // Accepts format: DD-MM-YYYY
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date dob = format.parse(dobStr);
            Date today = new Date();

            long ageInMillis = today.getTime() - dob.getTime();
            long age = ageInMillis / (1000L * 60 * 60 * 24 * 365); // rough estimate

            System.out.println("Age: " + age + " years");
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use DD-MM-YYYY.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter date of birth (DD-MM-YYYY): ");
        String dob = sc.nextLine();

        Person p = new Person(name);
        p.displayName();
        p.displayAge(dob);

        sc.close();
    }
}
