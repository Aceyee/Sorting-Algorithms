/* 
   RadixSort.java :  Sort 1,000,000 integers with O(k*n) time complexity.
					 k is the largest digits of the maximum value being sorted.
					 (i.e. k = 6 for 1,000,000 integers)

   Author	: Zihan Ye
   Date		: 2017.07.15
   GitHub	: https://github.com/Aceyee
   Email	: zaeye1028@gmail.com
*/
import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.File;

//Do not change the name of the HeapSort class
public class RadixSort{
	public static void RadixSort(int[] a){
		int K = 1000;
		ArrayList<LinkedList<Integer>> arraylist = new ArrayList<LinkedList<Integer>>();
		for(int i=0; i<K; i++){
			arraylist.add(i, new LinkedList<Integer>());
		}
		int l = a.length;
		int maxValue = a[0];

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
			digits *= K;
			numOfDigit++;
		}

		int m =K;
		int n =1;

		// k is a small constant

		for(int k=0; k<numOfDigit; k++){
			// n
			for(int i=0; i< l; i++){
				int value = a[i];
				int listIndex = value % m /n;
				arraylist.get(listIndex).addLast(value);
			}

			int index = 0;
			for(int j=0; j<K; j++){
				//System.out.println(b.length);
				int s = arraylist.get(j).size();
				for(int o =0; o< s; o++){
					a[index] = arraylist.get(j).removeFirst();
					index++;
				}
			}
			m*=K;
			n*=K;
		}
	}

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

		RadixSort(array);

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
		System.out.printf("Total Time (seconds): %.4f\n",totalTimeSeconds);
	}
}
