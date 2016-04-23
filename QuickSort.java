// Calvin Vuong
// APCS2 pd10
// HW34 -- An Optimized Version of This is Java's Built-In Sort Mechanism
// 2016-04-20

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): Partition the whole array. Then, partition all the values to the left of the pivot value resting place, and partion all the values to the right of the pivot value resting place. Recursively partition the left and rights of the pivots until the bounds marking the sections to pivot (lo and hi) cross each other, in which case, return. 
 *
 * 2a. Worst pivot choice and associated runtime: pivot is first or last element; O(n^2) if array is nearly sorted
 *
 * 2b. Best pivot choice and associated runtime: pivot is a random element; O(nlogn)
 *
 * 3. Approach to handling duplicate values in array: The quicksort algo summarized above handles duplicates just fine. There is no need to handle them specially.
 *
 *****************************************************/

public class QuickSort {

    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d ) { 
	qsortH( d, 0, d.length );
    }

    //you may need a helper method...

    // lo and hi mark the range of indicies of int[] d we are sorting
    // parameters allow for recursive calling
    public static void qsortH( int[] d, int lo, int hi ) {
	if ( lo >= hi )
	    return;
	int pivotPos = partition( d, (int)(Math.random() * (hi-lo) + lo) , lo, hi ); // partition about random element
	qsortH( d, lo, pivotPos ); // sort to the left
	qsortH( d, pivotPos+1, hi ); // sort to the right
    }

    // partitions elements between lo and hi-1 inclusive in int[] arr, given a pvtPos
    public static int partition(int[] arr, int pvtPos, int lo, int hi) {
	int pvtVal = arr[pvtPos];
	swap(pvtPos, hi-1, arr); // put pivot at end
	int savPos = lo;
	for ( int i = lo; i < hi-1; i++ ){
	    if ( arr[i] < pvtVal ){
		swap(savPos, i, arr);
		savPos += 1;
	    }
	}
	swap(hi-1, savPos, arr);
	return savPos;
    }


    //main method for testing
    public static void main( String[] args ) {


	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);
	
	
	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 	
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
