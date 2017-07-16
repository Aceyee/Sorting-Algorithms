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

	public void mergesort(int[] a, int low, int high){
		if (low < high)
        {
            int mid = (low+high)/2;
			mergesort(a, low, mid);
			mergesort(a, mid+1, high);
		
			merge(a, low, mid ,high);
		}
	}

	public int[] merge(int []a, int low, int mid, int high){ 
		int l1 = mid-low+1;
		int l2 = high-mid;
		int []L = new int[l1];
		int []R = new int[l2];
		
		for(int k=0; k<L.length; k++){
			L[k] = a[low+k];
		}

		for(int k=0; k<R.length; k++){
			R[k] = a[mid+k+1];
		}

		int i =0;
		int j =0;
		int index = low;

		while(i<l1 && j<l2){
			if(L[i]<R[j]){
				a[index] = L[i];
				index++;
				i++;
			}else{
				a[index] = R[j];
				index++;
				j++;
			}
		}
		while(i<l1){
			a[index] = L[i];
			index++;
			i++;
		}
		while(j<l2){
			a[index] = R[j];
			index++;
			j++;
		}
		/*
		for(int k=0; k<a.length; k++){
			System.out.print(a[k]+" ");
		}
		System.out.println();*/
		return a;
	}
}