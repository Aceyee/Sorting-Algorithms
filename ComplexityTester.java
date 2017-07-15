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
public class ComplexityTester{
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
		System.out.printf("************************************\n");
		System.out.printf("Welcome to Zihan's Complexity Tester\n");
		System.out.printf("************************************\n");
		System.out.printf("\n");
		System.out.printf("Radix Sort: \t1\n");
		System.out.printf("Heap Sort: \t2\n");
		System.out.printf("\n");

		System.out.printf("Please input your choice:\n");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		System.out.println("You have chose "+ choice);

		Vector<Integer> inputVector = new Vector<Integer>();

		int v;
		while(s.hasNextInt() && (v = s.nextInt()) >= 0)
			inputVector.add(v);

		int[] array = new int[inputVector.size()];

		for (int i = 0; i < array.length; i++)
			array[i] = inputVector.get(i);

		System.out.printf("Read %d values.\n",array.length);


		long startTime = System.currentTimeMillis();

		//array = RadixSort(array);

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
