/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userkernel;

import java.io.FileWriter;
import java.util.*;
import sortingalgorithm.*;

/**
 *
 * @author fchishtie
 */
public class UserKernel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws java.io.IOException {
        double a[] = new double[4];
        double b[] = new double[4];
        double c[] = new double[4];
        for (int i = 0; i < 4; i++) {
            a[i] = i; //result array
            b[i] = 10 - i;
            c[i] = 9+i;
        }
        List<newStudent> Students = Arrays.asList(
                new newStudent("Jack", "Smith", "UWO", "I'm a student", a, 9893249, 3),
                new newStudent("Bob", "Lee", "Waterloo", "I'm a student", b, 7630753, 1),
                new newStudent("Brad", "Bradson", "Queens", "I'm a dog", c, 8181002, 2)
        );
        Person List[] = new Person[3];
        int count = 0;
        for (newStudent d : Students) {
            newStudent.initializeStudent(d);
            Person temp = new Person(d.results, d.first_name);
            List[count] = temp;
            count++;
        }
        for (int i = 0; i < VectorSort.Angles(List).length; i++){
        System.out.println(VectorSort.Angles(List)[i]);
        }
    }

}
