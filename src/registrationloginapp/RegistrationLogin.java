/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrationloginapp;

/**
 *
 * @author Student
 */
public class RegistrationLogin {
    
      // Variables to store the user's registration details
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // Constructor to store the user's first and last name
    public RegistrationLogin(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Checks if the username contains an underscore
    // and is no more than 5 characters long
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Checks if the password meets the complexity requirements
    // The password must have at least 8 characters,
    // a capital letter, a number, and a special character
    public boolean checkPasswordComplexity(String password) {

        if (password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        // Loops through each character in the password
        for (int i = 0; i < password.length(); i++) {

            char character = password.charAt(i);

            // Checks for a capital letter
            if (Character.isUpperCase(character)) {
                hasCapital = true;
            }

            // Checks for a number
            if (Character.isDigit(character)) {
                hasNumber = true;
            }

            // Checks for a special character
            if (!Character.isLetterOrDigit(character)) {
                hasSpecial = true;
            }
        }

        // Returns true only if all requirements are met
        return hasCapital && hasNumber && hasSpecial;
    }

    // Checks if the cellphone number starts with +27
    // and contains exactly 9 digits after the country code
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {

        // Regular expression for a South African cellphone number
        String phoneRegex = "^\\+27[0-9]{9}$";

        return cellPhoneNumber.matches(phoneRegex);
    }

    // Registers the user and returns a registration message
    public String registerUser(String username, String password,
                               String cellPhoneNumber) {

        // Check if the username is correctly formatted
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        // Check if the password is correctly formatted
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        // Check if the cellphone number is correctly formatted
        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code";
        }

        // Save the user's details after successful validation
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;

        return "User registered successfully.";
    }

    // Checks if the entered login details match the
    // username and password saved during registration
    public boolean loginUser(String enteredUsername, String enteredPassword) {

        return enteredUsername.equals(username)
                && enteredPassword.equals(password);
    }

    // Returns a message showing whether the login was successful
    public String returnLoginStatus(boolean loginSuccessful) {

        if (loginSuccessful) {
            return "Welcome " + firstName + ", " + lastName
                    + " it is great to see you again.";
        }
    System.out.println("Welcome " + firstName + " it is great to see you again.");
            ChatBot.main(null); 
        return "Username or password incorrect, please try again.";
    }
}
