import java.util.ArrayList;

public class Driver{
    public static void main(String[] args){
	ArrayList cadie = MySorts.populate( 10, 1, 100);
	System.out.println("ArrayList cadie before sorting:\n" + cadie);
	MySorts.bogoSort(cadie);
	System.out.println("ArrayList cadie after sorting:\n" + cadie);
    }
}
	