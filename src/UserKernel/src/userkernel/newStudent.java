/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userkernel;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import session.userid.UserID;

/**
 * Class that contains the content of a given student + writes a csv file with their username
 * @author fchishtie
 */
public class newStudent {

    public String first_name, last_name, university, description;
    public double[] results;
    public int phone_number, num_roomies, userID;
    public static String FILE_LOC = "/Users/fchishtie/Desktop/UserData/";
    
    /**
     * Constructor method for the newStudent class
     * @param first first name
     * @param last last name 
     * @param uni university attending
     * @param desc personal description - maybe ask this later
     * @param results results from survey compiled here
     * @param phone phone number
     * @param roomie number of roommates they are looking for
     */
    public newStudent(String first, String last, String uni, String desc, double[] results, int phone, int roomie) {
        this.first_name = first;
        this.last_name = last;
        this.university = uni;
        this.description = desc;
        this.results = results;
        this.phone_number = phone;
        this.num_roomies = roomie;
        UserID temp = new UserID(7); //creates new user ID for the newStudent but is not shown to student
        this.userID = temp.NewUID();
    }

    /**
     * Function that initializes the new student by writing the csv file
     * @param d new student d
     * @throws IOException 
     */
    public static void initializeStudent(newStudent d) throws IOException {
        String pointer = FILE_LOC + d.userID + ".csv"; //will change when server is declared
        FileWriter writer = new FileWriter(pointer); //creates a new filewriter object
       

        String phone = "" + d.phone_number; //small trick to get int in csv file
        String roomies = "" + d.num_roomies;
        String userID = "" + d.userID;
        String results = "{"; //starts the results off with this key to keep everything in brackets
        for (int i = 0; i < d.results.length; i++) {
            if (i == d.results.length - 1) {
                results += d.results[i] + "}"; //ends bracket
                break;
            }
            results += d.results[i] + ","; 
        }

        List<String> list = new ArrayList<>(); //creates new list to add to csv file
        list.add(d.first_name);
        list.add(d.last_name);
        list.add(d.university);
        list.add(d.description);
        list.add(results);
        list.add(phone);
        list.add(roomies);
        list.add(userID);

        CSVUtils.writeLine(writer, list); //writes the file into the csvfile

        writer.flush(); //closes writers
        writer.close();
    }

}
