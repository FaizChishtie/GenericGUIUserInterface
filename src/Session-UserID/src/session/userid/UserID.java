/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.userid;
import java.util.*;

/**
 * Creates new user ID
 * @author fchishtie
 */
public class UserID {
    
    public static int number_of_digits;
    
    public UserID(int a){
        this.number_of_digits = a;
    }
    
    /**
     * Creates new user ID based on number given when object constructed
     * @return returns the new id
     */
    public static int NewUID(){
    
        int digits[] = new int[number_of_digits];
        
        Random random_g = new Random();
        for (int i = 0; i < number_of_digits; i++){
            int rand_num = random_g.nextInt(10);
            
            if (rand_num == 10){
                rand_num -= random_g.nextInt(5);
            }
            
            digits[i] = rand_num;
        }
        return DigitToInt(digits);
    }
    
    /**
     * Digit to int appends an array of numbers to an integer
     * @param n the array with randomly generated numbers
     * @return returns the int
     */
    public static int DigitToInt (int n[]){
        String integer = "";
            for (int i = 0; i < number_of_digits; i++){
            integer += n[i];
        }
        return Integer.parseInt(integer);
    }
}
