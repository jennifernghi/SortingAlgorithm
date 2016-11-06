/**
 * 
 * @author Nghi Nguyen
 * HeapSort algorithm
 */
public class HeapSort{

	//DataHandler Object - to use methods in DataHandler class
	public static final DataHandler datahandler = new DataHandler();
	private int heapsize; //hold the size of the heap

	/**
	 * this maxHeapify method used only for input data file
	 * 
	 * @param array - unsorted String array
	 * @param i - the position of the node
	 */
	public <T extends Comparable<T>> void maxHeapifyForDataFile(String[] array, int i){
		if(heapsize>1 && i< heapsize){
			
			int largestIndex =i; //current node, let current node is the largest
			int leftChildIndex = (2*i) +1; //left child index of the current node
			int rightChildIndex = (2*i)+2;//right child index of the current node
			
			/*
			 * if left child is larger than the node, then assign its index to the largestIndex
			 * otherwise, largestIndex is still the index of current node
			 * use getFirstIntToken() to extract the number to compare
			 */
			if(leftChildIndex<= heapsize-1 && datahandler.getFirstIntToken(array[leftChildIndex]).compareTo(datahandler.getFirstIntToken(array[largestIndex]))>0){
				largestIndex = leftChildIndex;
			}else{
				largestIndex = i;
			}
			
			/*
			 * if right child is larger than the node, then assign its index to the largestIndex
			 * otherwise, largestIndex is still the index of current node
			 * use getFirstIntToken() to extract the number to compare
			 */
			if(rightChildIndex<= heapsize-1 && datahandler.getFirstIntToken(array[rightChildIndex]).compareTo(datahandler.getFirstIntToken(array[largestIndex]))>0){
				largestIndex = rightChildIndex;
			}
			
			/**
			 * if largestIndex is not the current node, then swap array[i] with array[largestIndex]
			 * then recursive call maxHeapifyForDataFile until i>= heapsize
			 */
			if(largestIndex != i){
				datahandler.swap(array, i, largestIndex);
				maxHeapifyForDataFile(array, largestIndex);
			}
		}	
	}
	/**
	 * this maxHeapify method is generic, used for any type of array
	 * 
	 * @param array - unsorted generic array
	 * @param i - the position of the node
	 */
	public <T extends Comparable<T>> void maxHeapify(T[] array, int i){
		if(heapsize>1 && i< heapsize){
			
			int largestIndex =i;//current node, let current node is the largest
			int leftChildIndex = (2*i) +1;//left child index of the current node
			int rightChildIndex = (2*i)+2;//right child index of the current node
		
			/*
			 * if left child is larger than the node, then assign its index to the largestIndex
			 * otherwise, largestIndex is still the index of current node
			 */
			if(leftChildIndex<= heapsize-1 && array[leftChildIndex].compareTo(array[largestIndex])>0){
				largestIndex = leftChildIndex;
			}else{
				largestIndex = i;
			}
			
			/*
			 * if right child is larger than the node, then assign its index to the largestIndex
			 * otherwise, largestIndex is still the index of current node
			 */
			if(rightChildIndex<= heapsize-1 && array[rightChildIndex].compareTo(array[largestIndex])>0){
				largestIndex = rightChildIndex;
			}
			
			/**
			 * if largestIndex is not the current node, then swap array[i] with array[largestIndex]
			 * then recursive call maxHeapifyForDataFile until i>= heapsize
			 */
			if(largestIndex != i){
				datahandler.swap(array, i, largestIndex);
				maxHeapify(array, largestIndex);
			}
		}	
	}
	/**
	 * BUILD-MAX-HEAP(A)
	 * A.heap-size = A.length
	 * for i =A.length/2 down to 1
	 *	MAX-HEAPIFY(A, i)
	 */
	/**
	 * this buildMaxHeap method used only for input data file
	 * @param array - String array
	 */
	public <T extends Comparable<T>> void buildMaxHeapForDataFile(String[] array){
			
			for (int i = (int)Math.floor((array.length)/2); i>=0; i--){
				
				maxHeapifyForDataFile(array, i);
			}
		}
	/**
	 * this buildMaxHeap method is generic, used for any type of array
	 * @param array - String array
	 */
	public <T extends Comparable<T>> void buildMaxHeap(T[] array){
		
		for (int i = (int)Math.floor((array.length)/2); i>=0; i--){
			
			maxHeapify(array, i);
		}
	}
	
	/**
	  * BUILD-MAX-HEAP(A)
	  *		for i= A.length down to 2
	  *		exchange A[1] with A[i]
	  *		A.heap-size = A.heap-size -1
	  *		MAX-HEAPIFY(A,1)
	 */
	/**
	 * This heapsort is used only to sort data file
	 * @param array - String array
	 */
	public <T extends Comparable<T>> void heapSortForDataFile(String[] array){
		
		heapsize = array.length;//initialize heapsize
		buildMaxHeapForDataFile(array);
		for(int i =heapsize-1; i> 0; i--){
			datahandler.swap(array, 0, i);
			heapsize--;
			maxHeapifyForDataFile(array, 0);
		}
		
	}
	/**
	 * This heapsort is generic for any array type
	 * @param array - generic array
	 */
	public <T extends Comparable<T>> void heapSort(T[] array){
			
			heapsize = array.length;
			buildMaxHeap(array);
			for(int i =heapsize-1; i> 0; i--){
				datahandler.swap(array, 0, i);
				heapsize--;
				maxHeapify(array, 0);
			}
			
		}
	
	public static void main(String[] args) {
		HeapSort heapSort = new HeapSort();
		datahandler.run(heapSort, args);
	}
	
	
	
	
}
