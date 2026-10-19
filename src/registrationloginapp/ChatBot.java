package registrationloginapp;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class ChatBot {
    /**
     * @param args the command line arguments
     */
    //create a one dimensional array 
    private static Message[] messages = new Message[100];

    private static int messageCount = 0;

    public static void main (String[] args) {
        
        //creating  scanner to recieve user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== WELCOME TO QUICKCHAT =====");

        boolean loop = true;

        while (loop) {
            
            //Display menu to user
            System.out.println("MENU:");

            System.out.println("1) Send message");

            System.out.println("2) Show recently sent messages");

            System.out.println("3) Quit");
            
            //ask user to choose from menu
            System.out.print("Enter your option: ");

            int option = scanner.nextInt();

            scanner.nextLine();
            
            //Display what user chooses from menu
            if (option == 1) {

                sendMessage(scanner);

            } else if (option == 2) {

                showMessages();

            } else if (option == 3) {

                loop = false;

                System.out.println("Goodbye!");

            } else {

                System.out.println("Invalid option. Please try again.");

            }

        }

    }
    
    //create a method to send messages
    public static void sendMessage(Scanner scanner) {
        
        //ask user how many messages do they want to send 
        System.out.print("How many messages do you want to send? ");

        int numMessages = scanner.nextInt();

        scanner.nextLine();
        
        // Loop for user to send multiple messages
        for (int count = 0; count < numMessages; count++) {

            if (messageCount >= messages.length) {

                System.out.println("Message storage is full.");

            } else {
                 
                //ask user to enter number using internationsl code
                System.out.print("Enter recipient's cell number:(Must start with +27) ");

                String recipient = scanner.nextLine();
                
                // Regular expression for a South African cellphone number
                String phoneRegex = "^\\+27[0-9]{9}$";
                
                if(recipient.matches(phoneRegex)){
                 
                }
                //must display a error message
                //if user does not use international code
                else{
                    System.out.println("Cell phone number is incorrectly formatted or does not contain international code.");
                }
                
                //ask user to enter messages not longer than 250
                System.out.print("Enter your message (maximum 250 characters): ");

                String content = scanner.nextLine();
                
                //Display if user does not enter any charaters
                if (content.length() == 0) {

                    System.out.println("Message cannot be empty.");
                    
                //Display if user enters max 250 characters
                } else if (content.length() > 250) {

                    System.out.println(

                        "Message must not exceed 250 characters."

                    );

                } else {
                    
                    //create a new message key with number and messages
                    Message message = new Message(recipient, content);

                    //ask user what to do with message
                    System.out.println("\nWhat would you like to do with this message?");
                    System.out.println("1) Send Message");
                    System.out.println("2) Disregard Message");
                    System.out.println("3) Store Message to send later");
                    System.out.print("Enter choice: ");
                    int action = scanner.nextInt();
                    scanner.nextLine();

                    if(action == 1){
                        //store message in array
                        messages[messageCount] = message;
                        messageCount++;
                        
                        //Display if message is sent
                        //Display message Hash
                        //Display recipient
                        //Display message content
                        System.out.println("Message successfully sent");

                        System.out.println("Message ID: " + message.getMessageId());

                        System.out.println("Message Hash: " + message.getMessageHash());

                        System.out.println("Recipient: " + message.getRecipient());

                        System.out.println("Message: " + message.getContent());
                    }
                    else if(action == 2){
                        //ask user to press 0 to delete
                        System.out.print("Press 0 to delete the message: ");
                        int del = scanner.nextInt();
                        scanner.nextLine();
                        if(del == 0){
                            //must display Press 0 to delete the message
                            System.out.println("Press 0 to delete the message");
                            System.out.println("Message disregarded");
                        }
                    }
                    else if(action == 3){
                        //store message in JSON file
                        storeMessageToJson(message);
                        //must display Message successfully stored
                        System.out.println("Message successfully stored");
                    }

                }

            }

        }
        //Display number of messages sent
        System.out.println("Total messages sent: " + messageCount);

    }

    public static void showMessages() {
        
        //Display if theres no messages that has been sent
        if (messageCount == 0) {

            System.out.println("No messages have been sent yet.");

        } else {
            
            //Display if user wants to see messages that were sent
            System.out.println("===== RECENTLY SENT MESSAGES =====");

            for (int i = 0; i < messageCount; i++) {

                System.out.println("Message " + (i + 1));

                System.out.println("Message ID: "

                        + messages[i].getMessageId());

                System.out.println("Message Hash: "

                        + messages[i].getMessageHash());

                System.out.println("Recipient: "

                        + messages[i].getRecipient());

                System.out.println("Content: "

                        + messages[i].getContent());

            }

        }

    }

    //method to store message in JSON file
    public static void storeMessageToJson(Message message){
        try {
            //create FileWriter to write to JSON file - fixed to avoid quote errors
            java.io.FileWriter file = new java.io.FileWriter("storedMessages.json", true);
            file.write("MessageID: " + message.getMessageId() + "\n");
            file.write("Hash: " + message.getMessageHash() + "\n");
            file.write("To: " + message.getRecipient() + "\n");
            file.write("Text: " + message.getContent() + "\n");
            file.write("---\n");
            file.close();
            System.out.println("Saved to storedMessages.json");
        } catch (Exception e){
            System.out.println("Error storing JSON: " + e.getMessage());
        }
    }

}

