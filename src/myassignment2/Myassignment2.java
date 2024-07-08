/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package myassignment2;

/**
 *
 * @author User
 */
public class Myassignment2 {

    public static void main(String[] args) {
        
      boolean accountControl = false;
      
     EntryPage newAccount = new EntryPage();
     
     newAccount.CreateAccount();
     
    
        
        if(newAccount.usernameCheck && newAccount.passwordCheck ){
            accountControl = false;
            
            
            
       
        
   
            
            
            
            
        }else{
            
           newAccount.LoginPortal();
            accountControl = true;
            
            
            
            
        
    }
            
            
            
            
        }
   
    }