/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.userid;

/**
 *
 * @author fchishtie
 */
public class SessionUserID {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int x = 0; x < 2000; x++){
        int j = 7;
        int k = 5;
        int IDS[] = new int[k];
        //System.out.println("Unsorted:");
        for (int i = 0; i < k; i++){
            UserID tmp = new UserID(j);
            IDS[i] = tmp.NewUID();
            //System.out.println(IDS[i]);
        }
        //System.out.println("Sorted:");
        SortUID m = new SortUID(IDS, 1);
        for (int i = 0; i < k; i++){
            //System.out.println(x.UIDs[i]);
        }
        int a[] = new int[100];
        for (int i = 0; i < 100; i++){
            a[i] = i+1;
        }
        UserID tmp = new UserID(j);
        int node = tmp.NewUID();
        System.out.println(SortUID.isExistID(m.UIDs,node) + " UID: " + node);
        }
    }
    
}
