/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.userid;

/**
 * Scans if UID is the same as any of the other users
 *
 * @author fchishtie
 */
public class SortUID {

    public static int[] UIDs; //will be sorted in constructor
    public static int ID_check;

    /**
     * Constructor method takes an array of users and a given id to find
     *
     * @param UIDs array of users
     * @param ID given id
     */
    public SortUID(int UIDs[], int ID) {
        this.UIDs = SortList(UIDs, 0); //sorts the list of users then stores
        this.ID_check = ID;
    }

    /**
     * Sorting method -- uses brute force for now
     *
     * @param UID array of users
     * @param index index that pointer is at to make swaps
     * @return returns sorted array
     */
    public static int[] SortList(int UID[], int index) {
        int n = index; //assigns index to n
        if (n >= UID.length) { //checks if n is greater than the length of users array
            if (CheckSort(UID)) { //checks if UID is sorted
                return UID; //returns sorted
            } else {
                return SortList(UID, 0); //starts algorithm over if not sorted
            }
        }
        boolean statements[] = Checker(UID, n); //creates a boolean array which answers if a in [b,a,c] is >=b & <=c
        if (isTrue(statements)) { //checks if b is less than c and greater than a by using isTrue function
            return SortList(UID, n + 1); //starts algorithm again with new pointer
        } else if (statements[0]) { //if the statement that a < c, but a < b, swap a with b 
            UID = Swap(UID, n, n - 1); //calls swap method
            return SortList(UID, n);
        } else if (statements[1]) {//if the statement that a > b, but a > c swap a with c
            UID = Swap(UID, n, n + 1); //calls swap method
            return SortList(UID, n);
        } else if (statements[1] && statements[2] == false) { //if the statement that a < b & a > c, swap b with c
            UID = Swap(UID, n - 1, n + 1); //calls swap method
            return SortList(UID, n);
        }
        return null;
    }

    /**
     * Swap method swaps two items in an array
     *
     * @param UID array to swap values within
     * @param a given value to swap with
     * @param b either greater than or less than a
     * @return returns array with swapped values
     */
    public static int[] Swap(int UID[], int a, int b) {
        int temp = UID[a]; //creates temporary storage at index a
        UID[a] = UID[b]; //replaces a with b
        UID[b] = temp; //replaces b with a
        return UID;
    }

    /**
     * Check method that sees if an array is sorted
     *
     * @param UID given array
     * @return returns true or false depending on the arrays sorted nature
     */
    public static boolean CheckSort(int UID[]) {
        for (int i = 0; i < UID.length - 1; i++) {
            if ((UID[i] < UID[i + 1]) == false) { //brute force checks the array
                return false;
            }
        }
        return true;
    }

    /**
     * isTrue method checks if a given boolean arrays values are both true
     *
     * @param b boolean array
     * @return returns true or false based on the values in the array
     */
    public static boolean isTrue(boolean b[]) {
        if (b[0] && b[1] == true) { //checks if true 
            return true;
        }
        return false;
    }

    /**
     * Checker method creates boolean array based on values within an array,
     * around an index i
     *
     * @param UID array to be checked
     * @param i index value
     * @return returns array of booleans
     */
    public static boolean[] Checker(int UID[], int i) {
        int temp[] = UID; //creates temporary array 
        int n = i; //n instead of i because n is nice
        boolean statements[] = new boolean[2]; //creates array
        if (n + 1 >= UID.length) { //catch cases, if the n+1 value in the array doesn't exist, that array value should return true by default
            statements[0] = true; //statement[0] corresponds to proceeding value in array
            statements[1] = (temp[n] >= temp[n - 1]);
            return statements;
        }
        if (n - 1 == -1) { //catch case is value before index doesnt exist, return true
            statements[0] = (temp[n] <= temp[n + 1]);
            statements[1] = true; //statement[1] corresponds to preceeding value in array
            return statements;
        } else { //normal case
            statements[0] = (temp[n] <= temp[n + 1]); //compares values
            statements[1] = (temp[n] >= temp[n - 1]); //compares values
            return statements;
        }
    }

    /**
     * Try recursive
     *
     * @return
     */
    public static boolean isExistID(int UID[], int id) {
        int g1, g2, g3;
        int length = UID.length;
        //create 3 arrays based on UID and stick nodes in at different positions
        int group_1[] = UID;
        int group_2[] = UID;
        int group_3[] = UID;
        g1 = CreateIndex(length, 3)[0];
        g2 = CreateIndex(length, 3)[1];
        g3 = CreateIndex(length, 3)[2];
        
        if(id > UID[UID.length-1]|| id < UID[0]){
            return false;
        }
        if(UID.length == 5){
            for (int i =0; i < 5; i++){
                if(UID[i]==id){
                    return true;
                } else{
                    return false;
                }
            }
        }
        
        
        if(id == group_1[g1]){
            return true;
        }
        if(id < group_1[g1]){
            return isExistID(CutArray(UID, 0, g1), id);
        }
        if(id > group_1[g1] && id < group_2[g2]){
            return isExistID(CutArray(UID, g1, g2), id);
        }
        if(id == group_2[g2]){
            return true;
        }
        if(id > group_2[g2] && id < group_3[g3]){
            return isExistID(CutArray(UID, g2, g3), id);
        }
        if(id == group_3[g3]){
            return true;
        }
        if(id > group_3[g3]){
            return isExistID(CutArray(UID, g3, UID.length), id);
        }
        return false;
    }

    /**
     *
     * @param length
     * @param num_split
     * @return
     */
    public static int[] CreateIndex(int length, int num_split) {
        int div = (int) length / num_split;
        int indeces[] = new int[num_split];
        int sum = 0;
        for (int i = 0; i < num_split; i++) {
            sum += div;
            indeces[i] = sum;
        }
        return indeces;
    }
    /**
     * 
     * @param array
     * @param start
     * @param end
     * @return 
     */
    public static int[] CutArray(int array[], int start, int end){
        int length = end-start;
        int temp[] = new int[length];
        for (int i = 0; i < array.length; i++){
            if (i >= start && i < end){
                temp[i] = array[i];
                if(i==end){
                temp[i] = array[i];
                break;
            }
        }
        
    }
        return temp;
    }
    
/**
    public static int PosOfID(int a[], int b[], int c[], int a1, int b1, int c1) {
        int id = ID_check;
        int tmp_1 = a[a1];
        int tmp_2 = b[b1];
        int tmp_3 = c[c1];
        int closest = PercentGreatest(id, tmp_1, tmp_2, tmp_3);
        //clean this up somehow
        if (closest == id && closest =) {
            return 
        }

    }

    public static int PercentGreatest(int id, int tmp_1, int tmp_2, int tmp_3) {
        int percentages[] = new int[3];
        int t1, t2, t3;
        percentages[0] = (int) (id / tmp_1) * 100;
        percentages[1] = (int) (id / tmp_2) * 100;
        percentages[2] = (int) (id / tmp_3) * 100;
        percentages = SortList(percentages, 0);
        
        if (percentages[2] == (int) (id / tmp_2) * 100) {
            return tmp_2;
        } else if (percentages[2] == (int) (id / tmp_3) * 100) {
            return tmp_3;
        } else {
            return tmp_1;
        }
    }
*/
    
}
