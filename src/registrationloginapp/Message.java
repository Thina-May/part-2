package registrationloginapp;

 
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class Message {
    //Variables to store message information
    private String recipient;
    private String content;
    private String messageId;
    private String messageHash;
    
    private static int messageCount= 0;
    
    //Constructor to initialize message details
    public Message(String recipient, String content){ 
        
        this.recipient = recipient;
        this.content = content;
        this.messageId = createmessageId();
        this.messageHash = createmessageHash();
        
        messageCount++;
    }
    //Create a random message Id
    public String createmessageId(){
        Random random = new Random();
        //makes sure it is 10 numbers long
        return String.format("%010d", random.nextInt(1000000000));
    }
    
    //Create a message hash
    public String createmessageHash(){
        String[]words = content.trim().split("\\s+");
         
        String firstWord="";
        String lastWord="";
        
        //checks message length
        if(content.trim().length()>0){
            firstWord= words[0];
            lastWord= words[words.length -1];
            
        }
        
        //returns the first two numbers of id
        return 
        messageId.substring(0, 2)+ ":" 
                + messageCount + ":" 
                + firstWord + " " + lastWord;
        
    }
    
    //methods to display message information
    public String getMessageId(){
        return messageId;
    }
    
    public String getMessageHash(){
        return messageHash;
    }
    
    public String getRecipient(){
        return recipient;
    }
    
    public String getContent(){
        return content;
    }
    
}
