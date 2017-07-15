/* 
   CountingSort.java :  Sort 1,000,000 integers with O(n + k) time complexity.

   Author	: Zihan Ye
   Date		: 2017.07.15
   GitHub	: https://github.com/Aceyee
   Email	: zaeye1028@gmail.com
*/

public class CountingSort extends Sort{
	public CountingSort(int []a){
		super(a);
	}

	public void sort(){
		CountingSort(array); //array is the variable extended from parent class Sort()
	}

	public void CountingSort(int[] a){
		int l = a.length;
		int maxValue = a[0];
		int minValue = a[0];

		// Find the maximum value and minimum, in order to get the range
		for (int i = 0; i < l; i++){
			if(a[i]>maxValue){
				maxValue = a[i];
			}
			if(a[i]<minValue){
				minValue = a[i];
			}
		}
		//System.out.println(maxValue+" "+minValue);

		int [] count = new int[maxValue-minValue+1];
		
		for (int i = 0; i < l; i++){
			int value = a[i];	
			count[value-minValue]++;
		}

		int []sumCount = new int[count.length];
		sumCount[0] = 1; //the first index must be 1 since it is the smallest value

		for (int i = 1; i < sumCount.length; i++){
			sumCount[i] = sumCount[i-1] + count[i];
			//System.out.print(count[i]+" ");
		}

		/*
		for (int i = 0; i < sumCount.length; i++){
			System.out.print(sumCount[i]+" ");
		}*/

		int []b = new int[l];
		for(int i=0; i<l; i++){
			b[i] = a[i];
		}

		for(int i=0; i<l; i++){
			int value = b[i];
			int indexA = b[i] - minValue; //IndexA is the index of sumCount
			int indexB = sumCount[indexA]-1;//IndexB is the index of the array being sorted
			a[indexB] = value;
			sumCount[indexA]--;	
		}
	}
}