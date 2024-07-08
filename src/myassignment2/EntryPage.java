package myassignment2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */

public class EntryPage {

    private String username;
    private String password;
    boolean loginStatus = false;
    boolean usernameCheck = false;
    boolean passwordCheck = false;
    boolean registerUser = false;
    boolean loginAttempt = false;
Task[] maker;
    //registerUser is specifically just for displaying a message in the case the user has met all the requirements and set the password and username correctly and confirms their details being logged in the creation of an account
    // the other booleans are set to false ordered to generally proceed unless true which shows error in this case . they act as individual markers for each catergory
    public void setUsername(String setUsername) {
        username = setUsername;
    }

    public void setPassword(String setPassword) {
        password = setPassword;
    }

    String firstName = JOptionPane.showInputDialog("Please enter your first name");
    String lastName = JOptionPane.showInputDialog("Please create your last name");

    public void CreateAccount() {

        String newUsername = JOptionPane.showInputDialog("Please create your username");
        checkUsername(newUsername);
        //this is placed right after more for the neatness of it but also consistency checking immediately the format of the newly created username

        String newPassword = JOptionPane.showInputDialog("Please create your password");
        checkPasswordComplexity(newPassword);
        //this does the same as listed above but for the password
    }

    public void registerUser() {
        JOptionPane.showMessageDialog(null, "User has been registered");
    }

    public void checkUsername(String newUsername) {

        do {

            if (newUsername.length() >= 5 && newUsername.contains("_") ) {
//the default use of most of our methods will will be variable name then method and for others class then method when calling it and making something static is typically a fix
                JOptionPane.showMessageDialog(null, "Username successfully captured.");
                setUsername(newUsername);

                usernameCheck = false;

            } else if (newUsername.length() >= 5) {
                JOptionPane.showMessageDialog(null, "Your username needs to contain an underscore. Please try again");
                usernameCheck = true;
                newUsername = JOptionPane.showInputDialog("Please create or enter your username");
            } else if (newUsername.length() < 5) {
                JOptionPane.showMessageDialog(null, "Your username needs to be atleast 5 characters and include an underscore. Please try again");
                usernameCheck = true;
                newUsername = JOptionPane.showInputDialog("Please create or enter your username");
            } else if (newUsername.length() < 5 && newUsername.contains("_")) {
                JOptionPane.showMessageDialog(null, "Your username is less than 5 characters. Please create a longer username");
                usernameCheck = true;
                newUsername = JOptionPane.showInputDialog("Please create or enter your username");
            } else {

                JOptionPane.showMessageDialog(null, "Your username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length >>");
                usernameCheck = true;
                newUsername = JOptionPane.showInputDialog("Please create or enter your username");
            }
        } while (usernameCheck);
    }

    public void checkPasswordComplexity(String newPassword) {
      
//this for for uppercase please learn from slides or videos
        do {

            //this covers the special characters within the password by recognising a pattern
            if (newPassword.length() >= 8 && Pattern.compile("([^a-zA-Z0-9])").matcher(newPassword).find() && Pattern.compile("[A-Z]").matcher(newPassword).find()) {
                JOptionPane.showMessageDialog(null, "Password successfully captured.");
                setPassword(newPassword);
                passwordCheck = false;

            } else if (newPassword.length() >= 8) {
                JOptionPane.showMessageDialog(null, "Your password does not contain a special character or Uppercase letter. Please create a password with a special character and atleast 1 Uppercase letter.");
                passwordCheck = true;
                newPassword = JOptionPane.showInputDialog("Please create or enter your password");
            } else if (newPassword.length() < 8) {
                JOptionPane.showMessageDialog(null, "Your password  must be atleast 8 characters and include an Uppercase letter and a special character. Please try again.");
                passwordCheck = true;
                newPassword = JOptionPane.showInputDialog("Please create or enter your password");
            } else if (newPassword.length() < 8 && Pattern.compile("([^a-zA-Z0-9])").matcher(newPassword).find()) {
                JOptionPane.showMessageDialog(null, "Your password must be atleast 8 characters and include an Uppercase letter. Please create a longer password with atleast 1 Uppercase letter");
                passwordCheck = true;
                newPassword = JOptionPane.showInputDialog("Please create or enter your password");
            } else if (newPassword.length() >= 8 && Pattern.compile("([^a-zA-Z0-9])").matcher(newPassword).find()) {
                JOptionPane.showMessageDialog(null, "Your password must include an uppercase letter . Please try again ");
                passwordCheck = true;
                newPassword = JOptionPane.showInputDialog("Please create or enter your password");
            } else if (Pattern.compile("([^a-zA-Z0-9])").matcher(newPassword).find()) {
                JOptionPane.showMessageDialog(null, "Your password must be atleast 8 characters and include an uppercase letter . Please try again ");
                passwordCheck = true;
                newPassword = JOptionPane.showInputDialog("Please create or enter your password");
            } else if (Pattern.compile("([A-Z])").matcher(newPassword).find()) {
                JOptionPane.showMessageDialog(null, "Your password must be atleast 8 characters and include a special character . Please try again ");
                passwordCheck = true;
                newPassword = JOptionPane.showInputDialog("Please create or enter your password");
            } else if (newPassword.length() < 8 && Pattern.compile("([A-Z])").matcher(newPassword).find()) {
                JOptionPane.showMessageDialog(null, "Your password must be atleast 8 characters and include an uppercase letter . Please try again ");
                passwordCheck = true;
                newPassword = JOptionPane.showInputDialog("Please create or enter your password");
            } else if (newPassword.length() >= 8 && Pattern.compile("([A-Z])").matcher(newPassword).find()) {
                JOptionPane.showMessageDialog(null, "Your password must include a special character . Please try again ");
                passwordCheck = true;
                newPassword = JOptionPane.showInputDialog("Please create or enter your password");
            } else {
                JOptionPane.showMessageDialog(null, "Your password is not correctly formatted, please ensure that your password is more than 8 characters in length and contains a special character");
                passwordCheck = true;
                newPassword = JOptionPane.showInputDialog("Please create or enter your password");
            }
        } while (passwordCheck);
    }

    public void LoginPortal() {

        String loginUsername = JOptionPane.showInputDialog("Please enter your username");
        //called this loginUsername because enteredUsername etc was getting too hard to remember in the code please check for any errors or old variable names 

        String loginPassword = JOptionPane.showInputDialog("Please enter your password");
        //the loginUser method is checking if the username and password we have entered is a match compared to what has been saved or set by our entry

        do {

            loginUser(loginUsername, loginPassword);
//the loginuser method is checking the password
            if (usernameCheck && passwordCheck) {

                loginAttempt = true;
//this has a different logic in the if and else compared to the rest of the code
                registerUser();

            } else {

                JOptionPane.showMessageDialog(null, "Your username or password is incorrect. Please try again");

                loginAttempt = false;
                //loginAttempt is being used to make use of the register User so it can print when someone has been registered  
            }
        } while (loginAttempt);
    }
    
     public void myMenu() {
            
            String selector = JOptionPane.showInputDialog("1.Add Tasks /n 2.This Feature is Coming Soon /n 3.Quit");
        int selection = Integer.parseInt(selector);
        int addtaskfunction = 1;
        
        Task newtask = new Task();
        
        switch(selection){
            
            case 1:
                 String chosenNumberOfTasks  = JOptionPane.showInputDialog("How many tasks would you like to perform");
           int chosenNumberOfTasksConverted = Integer.parseInt(chosenNumberOfTasks);
           
           maker = Task.createTask(chosenNumberOfTasksConverted);
          
          
           
            case 2:
         
         newtask.mySubMenu();
         
            case 3:
           break;
        }
     }
    
    

    public void loginUser(String loginUsername, String loginPassword) {
        loginStatus = true;

        if (loginUsername.equals(username) && loginPassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Logged in successfully.");
            JOptionPane.showMessageDialog(null, "Welcome , " + firstName + " " + lastName + " it is great to see you");
            JOptionPane.showMessageDialog(null, "Welcome user  : " + username);
             JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
            myMenu();

            
        } else {
            JOptionPane.showMessageDialog(null, "Username or password is incorrect. please try again");

            LoginPortal();
            loginStatus = false;
        }
        while (loginStatus);

//keep it at verifying both just like real life for the logging in part just like how they dont tell you whats wrong for security reasons so dont change this code
    }
    

    //might have to change the stuff with the false and tru according to the rubric as it asks for specific true values when something is valid
}
