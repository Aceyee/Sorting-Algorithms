/* 
	HeapSort.java :  Sort 1,000,000 integers with O(n * log n) time complexity.
					 

   Author	: Zihan Ye
   Date		: 2017.07.15
   GitHub	: https://github.com/Aceyee
   Email	: zaeye1028@gmail.com
*/

//Do not change the name of the HeapSort class
public class HeapSort extends Sort{
	/* HeapSort(A) Sort the array A using heap sort.*/
	public HeapSort(int []a){
		super(a);
	}
	public void sort(){
		HeapSort(array); //array is the variable extended from parent class Sort()
	}

	public static void HeapSort(int[] A){
		int lastIndexB = A.length;
		int [] B = new int[A.length+1];
		for(int i=0; i<A.length; i++){
			int j = i+1;
			insertion(j, A[i], B);
		}
		for(int index =0; index< B.length-1; index++){
			deletion(A, B, index, lastIndexB);
			lastIndexB--;
		}
	}
	public static void insertion(int i, int val, int [] B){
		int parent = i/2;
		
		B[i] = val;
		if(B[parent]!=0){
			if(B[i]<B[parent]){
				swap(i , parent, B);
				insertion(parent, B[parent], B);
			}
		}
	}
	public static void deletion(int []A, int []B, int index, int lastIndexB){
		A[index]=B[1];
		swap(1, lastIndexB, B);
		B[lastIndexB]=10000000;
		//System.out.println(sizeB);
		lastIndexB--;
		bubbleDown(1, B, lastIndexB);
		
	}
	public static void swap(int num1, int num2, int[]B){
		int curr = B[num1];
		B[num1] = B[num2];
		B[num2] = curr;
	}
	public static void bubbleDown(int index, int []B, int lastIndexB){
		int left = 2*index;
		int right = 2*index+1;
		
		if(left<=lastIndexB){
			//leftchild is not null
			if(right>lastIndexB){
				//rightchild is null
				if(B[index]>B[left]){
					swap(index, left, B);
					bubbleDown(left, B, lastIndexB);
				}
			}else{
				//rightchild is not null
				if(B[left]<B[right]){
					if(B[index]>B[left]){
						swap(index, left, B);
						bubbleDown(left, B, lastIndexB);
					}
				}else{
					if(B[index]>B[right]){
						swap(index, right, B);
						bubbleDown(right, B, lastIndexB);
					}
				}
			}
		}
	}
}
