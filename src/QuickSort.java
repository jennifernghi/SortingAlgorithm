/**
 * 
 * @author Nghi Nguyen
 * QuickSort algorithm with fixed pivot position
 */
public class QuickSort {
	//DataHandler Object - to use methods in DataHandler class
	public static final DataHandler dataHandler = new DataHandler();
	
	/**
	 * generic quicksort for any type of array
	 * @param array - generic array
	 */
	public <T extends Comparable<T>>void quickSort(T[] array){
		//call quickSort(T[] array, int start, int end) 
		quickSort(array, 0, array.length-1);
	}
	/**
	 * quicksort only for data file
	 * @param array - string array
	 */
	public <T extends Comparable<T>>void quickSortForDataFile(String[] array){
		//call (String[] array, int start, int end)
		quickSortForDataFile(array, 0, array.length-1);
	}
	/**
	 * Recusive sorting algorithm
	 * @param array - generic array
	 * @param start - first index of the array
	 * @param end - last index of the array
	 */
	public<T extends Comparable<T>> void quickSort(T[] array, int start, int end){
		if(start < end){//base case
			int pivotIndex = partition(array,start,end); //get the index of the pivot
			quickSort(array, start, pivotIndex-1);//sort the left part
			quickSort(array,pivotIndex+1,end);//sort the right part
		}
	}
	/**
	 * generic partition
	 * @param array - generic array
	 * @param start - first index of the array
	 * @param end - last index of the array
	 * @return new pivotIndex
	 */
	public <T extends Comparable<T>> int partition(T[] array, int start, int end){
		T pivot = array[end]; // the pivot is the last element
		int i = start-1;
		for(int j = start; j<end; j++){
			if(array[j].compareTo(pivot)<=0){
				i++;
				dataHandler.swap(array, i, j);
			}
		}
		dataHandler.swap(array, i+1, end);//swap the pivot, now elements on the left smaller than the pivot, and elements on the right larger than the pivot
		
		return i+1;// return new index of the pivot
	}
	
	/**
	 * quicksort method used only for data file
	 * @param array - String array
	 * @param start - first index of the array
	 * @param end - last index of the array
	 */
	public <T extends Comparable<T>> void quickSortForDataFile(String[] array, int start, int end){
		if(start < end){
			
			int pivotIndex = partitionForDataFile(array,start,end);
			quickSortForDataFile(array, start, pivotIndex-1);
			quickSortForDataFile(array,pivotIndex+1,end);
		}
	}
	/**
	 * partition method used only for data file
	 * @param array - string array
	 * @param start - first index of the array
	 * @param end - last index of the array
	 * @return new pivotIndex
	 */
	public <T extends Comparable<T>> int partitionForDataFile(String[] array, int start, int end){
		String pivot = array[end];
		int i = start-1;
		for(int j = start; j<end; j++){
			/*
			 * use getFirstIntToken to extract number to compare
			 */
			if(dataHandler.getFirstIntToken(array[j]).compareTo(dataHandler.getFirstIntToken(pivot))<=0){
				i++;
				dataHandler.swap(array, i, j);
			}
		}
		dataHandler.swap(array, i+1, end);
		return i+1;//new pivot index
	}
	
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		dataHandler.run(quickSort, args);
	}

}
