/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithm;

/**
 * Calculates angle between people's vectors and returns them relative to person 1
 * @author fchishtie
 */
public class VectorSort {
    
    public static int NUMBER_TRAITS = 4; //the number of traits that a given person has
     
    /**
     * The toVector function takes an array of persons and creates a 2d array of vectors based on the number of people and the number of results
     * @param p array of persons
     * @return returns 2d array of vectors 
     */
    public static double[][] toVector(Person p[]){
        double vectors[][] = new double[p.length][NUMBER_TRAITS];
        for (int i = 0; i < p.length; i++){
            for (int j = 0; j < NUMBER_TRAITS; j++){
                vectors[i][j] = Components(p[i])[j]; //creates a 2d array with vector components based on the number of people
            }
        }
        return vectors;
    }
    
    /**
     * Takes a given person and turns their results into components
     * @param p a given person 
     * @return returns an array with the components
     */
    public static double[] Components(Person p){
        double n[] = new double[NUMBER_TRAITS];
        for (int i =0; i < NUMBER_TRAITS; i++){
            n[i] = p.ret_results()[i]; //calls ret_results function from person, which contains the results of a given person
        }
        return n;
    }
    
    /**
     * This function calculates the angle between two given vectors
     * @param v_1 the first vector
     * @param v_2 the second vector
     * @return returns the angle found between the two vectors
     */
    public static double ThetaBetween(double[] v_1, double[] v_2){
        /*
        Dot product:
        v.u = a1*b1 + a2*b2 ... = |v|*|u|*cos(theta)
        theta = (a1*b1....)/(|v|*|u|)
        */
      
        double theta = 0;
        double mag_1, mag_2; //variables for the magnitude of the two vectors
        double sum = 0; //the sum of all the angle
        
        for (int i = 0; i < v_1.length; i++){
            double a = v_1[i];
            double b = v_2[i];
            sum += a*b; //multiplies the given components
        }
        mag_1 = Magnitude(v_1); //takes magnitude
        mag_2 = Magnitude(v_2);
        theta += sum/(mag_1*mag_2); //performs dot product
        
        double arccos = Math.acos(theta);
        
        return arccos;
    }
    
    /**
     * Calculates the magnitude of a given vector "v"
     * @param v given vector
     * @return returns the magnitude of v
     */
    public static double Magnitude(double[] v){
        double magnitude = 0;
        double sum = 0; //sums all squared components together
        
        for (int i = 0; i < v.length; i++){
            sum += Math.pow(v[i], 2); //squares individual components then adds them to the sum variable
        }
        magnitude = Math.sqrt(sum); //square roots the sum
        return magnitude;
    }
    
    /**
     * Calculates the angles between Person 1's vector and "n" others -- important to note all are relative to 1
     * @param p an array of people
     * @return returns an array containing the angles relative to 1
     */
    public static double[] Angles(Person p[]){
        double[][] vectors = toVector(p); //call toVector function so 2d array is created
        double[] angles = new double[p.length-1]; //array used to store angles
        
        double[] v = new double[NUMBER_TRAITS]; //the vector to compare to others
        double[] v_temp = new double[NUMBER_TRAITS];
        
        for (int i = 0; i < NUMBER_TRAITS; i++){
            v[i] = vectors[0][i]; // creates vector based on data of first column in 2d array
        }
        
        for (int i = 0; i < p.length-1; i++){ //p.length -1 so that the iteration can start at 0
                v_temp = TempVector(vectors, i+1); //creates a temportary vector 
                angles[i] = ThetaBetween(v,v_temp); //calls ThetaBetween to get angle between vectors
        }
        return angles;
    }
    
    /**
     * Temporary vector creator based on data in 2d array
     * @param a 2d array where vector is stored
     * @param k column where the data is located in the 2d array
     * @return returns the vector
     */
    public static double[] TempVector(double[][] a, int k){
        double b[] = new double[NUMBER_TRAITS];
        for (int i = 0; i < b.length; i++){
            b[i] = a[k][i];
        }
        return b;
    }
    
}
