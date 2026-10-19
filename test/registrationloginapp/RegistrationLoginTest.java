/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package registrationloginapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This test Matches RegistrationLogin(firstName, lastName) constructor and
 * registerUser(username, password, cellPhoneNumber) signature.
 *
 *
 *
 * @author Student
 */
public class RegistrationLoginTest {

    private RegistrationLogin app;

    public RegistrationLoginTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        app = new RegistrationLogin("Kyle", "Smith");
    }

    @AfterEach
    public void tearDown() {
    }

    // ================= assertEquals tests =================

    @Test
    public void testRegisterUser_AllDetailsCorrectlyFormatted() {
        String expected = "User registered successfully.";
        String actual = app.registerUser("kyl_1", "Ch&isec@ke99!", "+27838968976");
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUser_UsernameIncorrectlyFormatted() {
        String expected = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        String actual = app.registerUser("kyle!!!!", "Ch&isec@ke99!", "+27838968976");
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUser_PasswordDoesNotMeetComplexity() {
        String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        String actual = app.registerUser("kyl_1", "password", "+27838968976");
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUser_CellPhoneNumberIncorrectlyFormatted() {
        String expected = "Cell phone number incorrectly formatted or does not contain international code";
        String actual = app.registerUser("kyl_1", "Ch&isec@ke99!", "0838968976");
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnLoginStatus_Successful() {
        app.registerUser("kyl_1", "Ch&isec@ke99!", "+27838968976");
        boolean loggedIn = app.loginUser("kyl_1", "Ch&isec@ke99!");
        String expected = "Welcome Kyle, Smith it is great to see you again.";
        assertEquals(expected, app.returnLoginStatus(loggedIn));
    }

    @Test
    public void testReturnLoginStatus_Failed() {
        app.registerUser("kyl_1", "Ch&isec@ke99!", "+27838968976");
        boolean loggedIn = app.loginUser("kyl_1", "WrongPassword1!");
        String expected = "Username or password incorrect, please try again.";
        assertEquals(expected, app.returnLoginStatus(loggedIn));
    }

    // ================= assertTrue / assertFalse tests =================

    @Test
    public void testLoginSuccessful() {
        app.registerUser("kyl_1", "Ch&isec@ke99!", "+27838968976");
        assertTrue(app.loginUser("kyl_1", "Ch&isec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        app.registerUser("kyl_1", "Ch&isec@ke99!", "+27838968976");
        assertFalse(app.loginUser("kyl_1", "WrongPassword1!"));
    }

    @Test
    public void testUserNameCorrectlyFormatted_True() {
        assertTrue(app.checkUserName("kyl_1"));
    }

    @Test
    public void testUserNameIncorrectlyFormatted_False() {
        assertFalse(app.checkUserName("kyle!!!!"));
    }

    @Test
    public void testPasswordComplexity_True() {
        assertTrue(app.checkPasswordComplexity("Ch&isec@ke99!"));
    }

    @Test
    public void testPasswordComplexity_False() {
        assertFalse(app.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellPhoneNumber_True() {
        assertTrue(app.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneNumber_False() {
        assertFalse(app.checkCellPhoneNumber("0838968976"));
    }

}