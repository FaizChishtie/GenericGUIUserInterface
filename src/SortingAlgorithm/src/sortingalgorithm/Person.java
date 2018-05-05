/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 */
package sortingalgorithm;

/**
 * Person object, contains test results and language spoken
 * @author fchishtie
 */
public class Person {
    
    private double[] results; //where the first person is the person that the sorting is relative to
    private String language; //language of person -- may be removed
    
    /**
     * Constructor method for the Person Object
     * @param a the array containing the survey results
     * @param b the string that contains the language(s) spoken
     */
    public Person(double[] a, String b){
        this.results = a; 
        this.language = b;
    }
    
    /**
     * Returns the values of the results for the person
     * @return ^
     */
    public double[] ret_results(){
        return this.results;
    }
    
}
