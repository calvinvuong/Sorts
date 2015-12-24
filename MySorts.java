// Calvin Vuong
// APCS1 pd5
// HW53
// 2015-12-23

import java.util.ArrayList;

public class MySorts{

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
	//setup for traversal fr right to left
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }

    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) {
	for (int k = 0; k < data.size()-1; k++){ //pass through k-1 times if data is k elements
	    for (int i = data.size()-1; i > 0; i--){
		if ( data.get(i).compareTo(data.get(i-1)) < 0){ //check if swap necessary
		    //swapping algo
		    //use temp vars to hold vals
		    Comparable tmp1 = data.get(i); 
		    Comparable tmp2 = data.get(i-1);
 
		    data.set(i, tmp2); //place element tmp2 at index i, the prev site of old tmp2
		    data.set(i-1, tmp1); //and vice versa
		}
	    }
	}
		    
    }//end bubbleSortV -- O(n^2)


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ){
	//copy input into a new ArrayList to prevent aliasing problems
	ArrayList newList = new ArrayList<Comparable>();
	for (Comparable c : input){
	    newList.add(c);
	}

	bubbleSortV(newList); 
	return newList; //return sorted version
    }//end bubbleSort -- O(n^2)

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

    // VOID version of bogoSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    // employs helper function isSorted()
    public static void bogoSortV(ArrayList<Comparable> data){
	while ( !(isSorted(data)) ){ //while data not sorted
	    shuffle(data); //keep shuffling
	}
    } //end bogoSortV

    // ArrayList-returning bogoSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    // uses helper function isSorted()
    public static ArrayList<Comparable> bogoSort(ArrayList<Comparable> input){
	//copy input into a new ArrayList to prevent aliasing problems
	ArrayList newList = new ArrayList<Comparable>();
	for (Comparable c : input){
	    newList.add(c);
	}

	bogoSortV(newList); 
	return newList; //return sorted version
    }//end bogoSort

    // helper function isSorted(ArrayList)
    // returns true if ArrayList is sorted
    public static boolean isSorted(ArrayList<Comparable> data){
	for (int i = 0; i < data.size()-1; i++){
	    if (data.get(i).compareTo(data.get(i+1)) > 0){ //if a prev element larger than latter...
		return false; //not sorted
	    }
	}
	return true;
    }

}
