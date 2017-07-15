/* 
   RadixSort.java :  Sort 1,000,000 integers with O(k*n) time complexity.
					 k is the largest digits of the maximum value being sorted.
					 (i.e. k = 6 for 1,000,000 integers)

   Author	: Zihan Ye
   Date		: 2017.07.15
   GitHub	: https://github.com/Aceyee
   Email	: zaeye1028@gmail.com
*/
import java.util.ArrayList;
import java.util.LinkedList;

//Do not change the name of the HeapSort class
public class RadixSort extends Sort{

	public RadixSort(int []a){
		super(a);
	}

	public void sort(){
		RadixSort(array);
	}

	public void RadixSort(int[] a){
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
}
