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
	static Sort algorithm;
	public static String check(int choice, int []array){
		switch(choice){
			case 1:
				algorithm = new RadixSort(array);
				return "Radix Sort";
			case 2:
				algorithm = new HeapSort(array);
				return "Heap Sort";
			case 3:
				algorithm = new CountingSort(array);
				return "Counting Sort";
			case 4:
				algorithm = new QuickSort(array);
				return "Quick Sort";
			default:
				System.out.println("Invalid Number. Exiting the tester...");
				System.exit(-1);
				return "";
		}
	}
	public static void main(String[] args){
		System.out.printf("\n");
		System.out.printf("Welcome to Zihan's Complexity Tester\n");
		System.out.printf("\n");
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
		System.out.printf("\n");
		System.out.printf("Please choose a algorithm: \n");
		System.out.printf("\n");
		System.out.printf("Radix Sort: \t1\n");
		System.out.printf("Heap Sort: \t2\n");
		System.out.printf("Counting Sort: \t3\n");
		System.out.printf("Quick Sort: \t4\n");
		System.out.printf("\n");

		System.out.printf("Please input your choice: ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		//int choice = 4;
		System.out.printf("You have chose %s: %s\n", choice, check(choice, array));

		long startTime = System.currentTimeMillis();

		algorithm.sort();

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