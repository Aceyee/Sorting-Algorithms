/* 
   QuickSort.java :  Sort 1,000,000 integers with O(n * log n) time complexity.

   Author	: Zihan Ye
   Date		: 2017.07.15
   GitHub	: https://github.com/Aceyee
   Email	: zaeye1028@gmail.com
*/

public class QuickSort extends Sort{
	public QuickSort(int []a){
		super(a);
	}

	public void sort(){
		quicksort(array, 0, array.length-1);
	}

	public void quicksort(int[] a, int low, int high){
		if(low < high){
			int p = partition(a, low, high);
			quicksort(a, low, p-1);
			quicksort(a, p+1, high);
		}
	}
	
	public int partition(int []a, int low, int high){
		int pivot = a[high];
		int i = low - 1;
		for(int j=low; j<high; j++){
			if(a[j] <= pivot){
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i+1, high);
		return i+1;
	}
	public void swap(int []a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}