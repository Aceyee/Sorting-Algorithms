/* 
	Author: Zihan Ye
	Data: 2017.07.15
*/
import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;

//Do not change the name of the HeapSort class
public class RadixSort{
	
	/* HeapSort(A)
		Sort the array A using heap sort.
		You may add additional functions (or classes) if needed, but the entire program must be
		contained in this file.

		Do not change the function signature (name/parameters).
	*/
	public static int[] RadixSort(int[] a){
		ArrayList<ArrayList<Integer>> arraylist = new ArrayList<ArrayList<Integer>>(10);
		for(int i=0; i<10; i++){
			arraylist.add(i, new ArrayList<Integer>());
		}
		int l = a.length;
		int maxValue = -1;

		// Find the maximum value, in order to get its digits
		for (int i = 0; i < l; i++){
			if(a[i]>maxValue){
				maxValue = a[i];
			}
		}

		int digits = 1;
		int numOfDigit = 0;
		// Find the digits of the maximum value
		// digits should be 1 greater than the digit of maxValue
		while(maxValue/digits != 0){
			digits *= 10;
			numOfDigit++;
		}

		int m =10;
		int n =1;

		// k is a small constant
		int []b = new int[l];
		for(int k=0; k<numOfDigit; k++){
			// n
			for(int i=0; i< l; i++){
				int listIndex = a[i] % m /n;
				arraylist.get(listIndex).add(a[i]);
				//System.out.println(arraylist.get(listIndex));
			}

			int index = 0;
			for(int j=0; j<10; j++){
				//System.out.println(b.length);
				int s = arraylist.get(j).size();
				for(int o =0; o< s; o++){
					b[index] = arraylist.get(j).get(0);
					//System.out.println(arraylist.get(j) +" "+arraylist.get(j).size());
					arraylist.get(j).remove(0);
					index++;
				}
				//System.out.println(index);
			}
			a = b;
			m*=10;
			n*=10;
		}
		//System.out.println(maxValue +"/"+digits);
		/*
		for(int j=0; j<l; j++){
			System.out.print(a[j]+ " ");
		}
		System.out.println();*/
		return a;
	}
	
	/* main()
	   Contains code to test the HeapSort function. Nothing in this function
	   will be marked. You are free to change the provided code to test your
	   implementation, but only the contents of the HeapSort() function above
	   will be considered during marking.
	*/
	public static void main(String[] args){
		Scanner s;
		if (args.length > 0){
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
			s = new Scanner(System.in);
			System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
		}
		Vector<Integer> inputVector = new Vector<Integer>();

		int v;
		while(s.hasNextInt() && (v = s.nextInt()) >= 0)
			inputVector.add(v);

		int[] array = new int[inputVector.size()];

		for (int i = 0; i < array.length; i++)
			array[i] = inputVector.get(i);

		System.out.printf("Read %d values.\n",array.length);


		long startTime = System.currentTimeMillis();

		array = RadixSort(array);

		long endTime = System.currentTimeMillis();

		double totalTimeSeconds = (endTime-startTime)/1000.0;

		//Don't print out the values if there are more than 100 of them
		if (array.length <= 100){
			System.out.println("Sorted values:");
			for (int i = 0; i < array.length; i++)
				System.out.printf("%d ",array[i]);
			System.out.println();
		}

		//Check whether the sort was successful
		boolean isSorted = true;
		for (int i = 0; i < array.length-1; i++)
			if (array[i] > array[i+1])
				isSorted = false;

		System.out.printf("Array %s sorted.\n",isSorted? "is":"is not");
		System.out.printf("Total Time (seconds): %.2f\n",totalTimeSeconds);
	}
}
