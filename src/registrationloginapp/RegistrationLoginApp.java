/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrationloginapp;

/**
 *
 * @author Student
 */

import java.util.Scanner;

public class RegistrationLoginApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          // Create a Scanner to receive input from the user
        Scanner scanner = new Scanner(System.in);

        // Display the registration heading
        System.out.println("===== REGISTRATION =====");

        // Ask the user for their first name
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        // Ask the user for their last name
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        // Create a RegistrationLogin object
        RegistrationLogin user = new RegistrationLogin(firstName, lastName);

        // Ask the user for a username
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Check if the username is correctly formatted
        if (user.checkUserName(username)) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
        }

        // Ask the user for a password
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check if the password meets the requirements
        if (user.checkPasswordComplexity(password)) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }

        // Ask the user for a cellphone number
        System.out.print("Enter South African cell phone number: ");
        String cellPhoneNumber = scanner.nextLine();

        // Check if the cellphone number is correctly formatted
        if (user.checkCellPhoneNumber(cellPhoneNumber)) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code");
        }

        // Register the user and display the registration result
        System.out.println();
        System.out.println(user.registerUser(username, password, cellPhoneNumber));

        // Display the login heading
        System.out.println();
        System.out.println("===== LOGIN =====");

        // Ask the user to enter their login username
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();

        // Ask the user to enter their login password
        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        // Check if the login details are correct
        boolean loginSuccessful = user.loginUser(loginUsername, loginPassword);

        // Display the login status message
        System.out.println(user.returnLoginStatus(loginSuccessful));
        if (loginSuccessful) {
    ChatBot.main(null);
}
        // Close the Scanner
        scanner.close();
    }
}