// Calvin Vuong
// APCS1 pd5
// HW52 -- Selection, Natch
// 2015-12-22

/*======================================
  class SelectionSort -- implements SelectionSort algorithm
  ======================================*/

import java.util.ArrayList;

public class SelectionSort {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    // employs helper function min
    public static void selectionSortV( ArrayList<Comparable> data ){
	for (int i = 0; i < data.size(); i++){ //make n-1 passes, n being size of data set
	    Comparable minVal = min(data, i); //find smallest value from index i to end
	    int minPos = data.indexOf(minVal); //find location of minVal
	    Comparable displaced = data.get(i); //find value to swap with minVal
	    
	    //swap
	    data.set(i, minVal); //move min to correct pos
	    data.set(minPos, displaced); //move displaced element to previous position of minVal
	}
    }//end selectionSort -- O(n^2)
    
    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) {
	//copy input into a new ArrayList to prevent aliasing problems
	ArrayList newList = new ArrayList<Comparable>();
	for (Comparable c : input){
	    newList.add(c);
	}

	selectionSortV(newList); 
	return newList; //return sorted version
    }//end selectionSort -- O(n^2)

    // helper function min(ArrayList, int)
    // returns minimum value in ArrayList from the index range to last element; inclusive
    public static Comparable min(ArrayList<Comparable> data, int range){
	Comparable currentMin = data.get(range); //default min value
	for (; range < data.size(); range++){ //iterate through data from range to end
	    if (data.get(range).compareTo(currentMin) < 0){ //if element at index i is less than current min...
		currentMin = data.get(range); //set currentMin to this val
	    }
	}
	return currentMin;
    }

    //main method for testing
    public static void main( String [] args ) {

	/*===============for VOID methods=============
	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  selectionSortV(glen);
	  System.out.println( "ArrayList glen after sorting:\n" + glen );

	

	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  selectionSortV(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );

	  ============================================*/


	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  ArrayList glenSorted = selectionSort( glen );
	  System.out.println( "sorted version of ArrayList glen:\n" 
	  + glenSorted );
	  System.out.println( "ArrayList glen after sorting:\n" + glen );

	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  ArrayList cocoSorted = selectionSort( coco );
	  System.out.println( "sorted version of ArrayList coco:\n" 
	  + cocoSorted );
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	  System.out.println( coco );
	/*==========for AL-returning methods==========
	  ============================================*/

    }//end main

}//end class SelectionSort
