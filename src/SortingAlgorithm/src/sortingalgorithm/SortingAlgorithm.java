/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithm;

/**
 *
 * @author fchishtie
 */
public class SortingAlgorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double a[] = new double[4];
        double b[] = new double[4];
        double c[] = new double[4];
        for (int i = 0; i < 4; i++){
            a[i] = 2*i; //result array
            b[i] = 10-i;
            c[i] = 2*i;
        }
        Person tom = new Person(a, "french");
        Person frank = new Person(b, "english");
        Person john = new Person(c, "spanish");
        
        Person list[] = new Person[3];
        list[0] = tom;
        list[1] = frank;
        list[2] = john;
        
        double angles[] = new double[list.length-1];
        
        angles = VectorSort.Angles(list);
        for (int i = 0; i < angles.length; i++){
            System.out.println(angles[i]);
        }
    }
    
}
