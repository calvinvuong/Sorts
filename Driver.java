// Calvin Vuong
// APCS1 pd5
// HW53
// 2015-12-23

import java.util.ArrayList;

public class Driver{
    public static void main(String[] args){
	System.out.println("Testing bubble sort: ");
	ArrayList cadie = MySorts.populate( 50, 1, 100);
	System.out.println("ArrayList cadie before sorting:\n" + cadie);
	MySorts.bubbleSortV(cadie);
	System.out.println("ArrayList cadie after sorting:\n" + cadie);
	System.out.println("");

	System.out.println("Testing selection sort: ");
	ArrayList regina = MySorts.populate( 50, 1, 1000);
	System.out.println("ArrayList cadie before sorting:\n" + regina);
	MySorts.selectionSortV(regina);
	System.out.println("ArrayList cadie after sorting:\n" + regina);
	System.out.println("");

	System.out.println("Testing bogo sort: ");
	ArrayList gretchen = MySorts.populate( 10, 1, 500);
	System.out.println("ArrayList cadie before sorting:\n" + gretchen);
	MySorts.bogoSortV(gretchen);
	System.out.println("ArrayList cadie after sorting:\n" + gretchen);
	System.out.println("");

    }
}
	