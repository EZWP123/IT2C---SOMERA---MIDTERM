package students.midterm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentsMidterm {

    public void addStudents() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Student Name: ");
        String sname = sc.next();
        System.out.print("Age: ");
        String age = sc.next();
        System.out.print("Address: ");
        String address = sc.next();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Phone Number: ");
        String pnumber = sc.next();

        String sql = "INSERT INTO students (name, age, email, address, phone_number) VALUES (?, ?, ?, ?, ?)";

        conf.addRecord(sql, sname, age, email, address, pnumber);
    }

    private void viewStudents() {
        config conf = new config();
        String cqry = "SELECT * FROM students";
        String[] hrds = {"ID", "Name", "Age", "Email", "Address", "Phone Number"};
        String[] clmns = {"id", "name", "age", "email", "address", "phone_number"};

        conf.viewRecords(cqry, hrds, clmns);
    }

    private void updateStudents() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to update");
        int id = sc.nextInt();

        System.out.println("Enter Student name");
        String sname = sc.next();

        System.out.println("Enter new age");
        String age = sc.next();

        System.out.println("Enter new email");
        String email = sc.next();

        System.out.println("Enter new Address");
        String address = sc.next();

        System.out.println("Enter new phone number");
        String pnumber = sc.next();

        String qry = "UPDATE students SET name = ?, age = ?, email = ?, address = ?, phone_number = ? WHERE id = ?";
        config conf = new config();
        conf.updateRecord(qry, sname, age, email, address, pnumber, id);
    }

    private void deleteStudents() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Enter ID to delete: ");
        int r_id = sc.nextInt();

        String deleteSql = "DELETE FROM students WHERE id = ?";
        conf.deleteRecord(deleteSql, String.valueOf(r_id));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String response;

        do {
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");

            System.out.println("Enter action");

            int action = sc.nextInt();

            StudentsMidterm demo = new StudentsMidterm();

            switch (action) {
                case 1:
                    demo.addStudents();
                    break;
                case 2:
                    demo.viewStudents();
                    break;
                case 3:
                    demo.updateStudents();
                    demo.viewStudents();
                    break;
                case 4:
                    demo.viewStudents();
                    demo.deleteStudents();
                    demo.viewStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return; // Exit the program
                default:
                    System.out.println("Invalid action. Please try again.");
            }

            System.out.print("Continue? (yes/no): ");
            response = sc.next();
        } while (response.equalsIgnoreCase("yes"));

        System.out.println("Thank you!");
    }
}