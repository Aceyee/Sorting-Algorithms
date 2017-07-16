/* 
   MergeSort.java :  Sort 1,000,000 integers with O(n * log n) time complexity.

   Author	: Zihan Ye
   Date		: 2017.07.15
   GitHub	: https://github.com/Aceyee
   Email	: zaeye1028@gmail.com
*/

public class MergeSort extends Sort{
	public MergeSort(int []a){
		super(a);
	}

	public void sort(){
		mergesort(array, 0, array.length-1);
	}
	// 3 1 4     5 6 2
	// 3 1  4
	//
	public void mergesort(int[] a, int low, int high){
		int l = high-low+1;
		//System.out.println(l);
		if(l==1){
			return;
		}
		int mid = 0;
		if(l%2==0){
			mid = l/2-1;
		}else{
			mid = l/2;
		}
		mergesort(a, 0, mid);
		mergesort(a, mid+1, high);
		
		merge();
	}
}