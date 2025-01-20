package com.example.crudapp;

import com.example.crudapp.service.UserService;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        try {
            userService.initializeDatabase();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nCRUD Application");
                System.out.println("1. Add User");
                System.out.println("2. View All Users");
                System.out.println("3. Update User");
                System.out.println("4. Delete User");
                System.out.println("5. Exit");
                System.out.println("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter email: ");
                        String email = scanner.nextLine();
                        userService.addUser(name, email);
                        break;

                    case 2:
                        userService.getUsers().forEach(System.out::println);
                        break;

                    case 3:
                        System.out.println("Enter user id to update: ");
                        int idToUpdate = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.println("Enter new email: ");
                        String newEmail = scanner.nextLine();
                        userService.updateUser(idToUpdate, newName, newEmail);
                        break;

                    case 4:
                        System.out.println("Enter user id to delete: ");
                        int idToDelete = scanner.nextInt();
                        userService.deleteUser(idToDelete);
                        break;
                    case 5:
                        System.out.println("Invalid choice. Try again.");
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
