/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userkernel;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class that has algorithm that finds csv file based on the ID.
 * @author fchishtie
 */
public class FindID {
    
    public static int ID;
    public static String FILE_LOC = "/Users/fchishtie/Desktop/UserData/";
     
    /**
     * 
     * @param ID 
     */
    public FindID(int ID){
        this.ID = ID;
    }
    
    /**
     * This function reads the users csv file and returns their information
     * @return 
     */
    public static String[] retUser(){
        String csvFile = FILE_LOC + ID + ".csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] person = line.split(cvsSplitBy);

                return person;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
}
