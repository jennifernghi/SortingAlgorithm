import java.util.Random;
/**
 * 
 * @author Nghi Nguyen
 * QuickSort algorithm with random pivot position
 */
public class QuickSortRandomPivot {
	//DataHandler Object - to use methods in DataHandler class
	public static final DataHandler dataHandler = new DataHandler();
	/**
	 * generic quickSortRandomPivot for any type of array
	 * @param array - generic array
	 */
	public <T extends Comparable<T>>void quickSortRandomPivot(T[] array){
		//call quickSortRandomPivot(T[] array, int start, int end) 
		quickSortRandomPivot(array, 0, array.length-1);
	}
	
	/**
	 * Recursive quickSortRandomPivot algorithm
	 * @param array - generic array
	 * @param start - first index of the array
	 * @param end - last index of the array
	 */
	public<T extends Comparable<T>> void quickSortRandomPivot(T[] array, int start, int end){
		if(start < end){
			
			int pivotIndex = partitionRandomPivot(array,start,end);
			quickSortRandomPivot(array, start, pivotIndex-1);
			quickSortRandomPivot(array,pivotIndex+1,end);
		}
	}
	/**
	 * generic partitionRandomPivot
	 * @param array - generic array
	 * @param start - first index of the array
	 * @param end - last index of the array
	 * @return new pivotIndex
	 */
	public <T extends Comparable<T>> int partitionRandomPivot(T[] array, int start, int end){
		T pivot = getRandomPivot(array, start, end);//random pivot
		int i = start-1;
		for(int j = start; j<end; j++){
			if(array[j].compareTo(pivot)<=0){
				i++;
				dataHandler.swap(array, i, j);
			}
		}
		dataHandler.swap(array, i+1, end);
		return i+1;
	}
	/**
	 * quicksort only for data file
	 * @param array - string array
	 */
	public <T extends Comparable<T>>void quickSortRandomPivotForDataFile(String[] array){
		quickSortRandomPivotForDataFile(array, 0, array.length-1);
	}
	/**
	 * quickSortRandomPivotForDataFile method used only for data file
	 * @param array - String array
	 * @param start - first index of the array
	 * @param end - last index of the array
	 */
	public <T extends Comparable<T>> void quickSortRandomPivotForDataFile(String[] array, int start, int end){
		if(start < end){
			
			int pivotIndex = partitionRandomPivotForDataFile(array,start,end);
			quickSortRandomPivotForDataFile(array, start, pivotIndex-1);
			quickSortRandomPivotForDataFile(array,pivotIndex+1,end);
		}
	}
	/**
	 * partitionRandomPivotForDataFile method used only for data file
	 * @param array - string array
	 * @param start - first index of the array
	 * @param end - last index of the array
	 * @return new pivotIndex
	 */
	public <T extends Comparable<T>> int partitionRandomPivotForDataFile(String[] array, int start, int end){
		String pivot = getRandomPivot(array, start, end);
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
		return i+1;
	}
	/**
	 * this generic method randomly select pivot in the current array
	 * then swap the chosen pivot with the last element, now we can reuse the quicksort algorithm for fixed pivot 
	 * @param array - generic array
	 * @param start - first index of the array
	 * @param end - last index of the array
	 * @return the pivot
	 */
	public <T extends Comparable<T>> T getRandomPivot(T[] array, int start, int end){
		
		Random random = new Random();
		/**
		 * random.nextInt(end - start +1) generates any random integer from 0 to end - start +1 (exclusive)
		 * start + random.nextInt(end - start +1) make sure we don't get inappropriate index in current array
		 */
		int randomIndex =  start + random.nextInt(end - start +1);
		
		dataHandler.swap(array,randomIndex, end);// swap new pivot with the last element
		return array[end];//return new pivot
	}
	public static void main(String[] args) {
		QuickSortRandomPivot quickSort = new QuickSortRandomPivot();
		dataHandler.run(quickSort, args);

	}

}
