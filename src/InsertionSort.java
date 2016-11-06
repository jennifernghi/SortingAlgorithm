import java.io.IOException;
/**
 * 
 * @author Nghi Nguyen
 *
 */
public class InsertionSort {
	//DataHandler Object - to use methods in DataHandler class
	public static final DataHandler datahandler = new DataHandler();
	/**
	 * insertion sort the input data file according to the first numeric column
	 * pre: the data unsorted 
	 * post: sort the data by the numeric column
	 * @param list - string array
	 */
	public <T extends Comparable<T>> void insertionSortForDataFile(String[] list){
			
			for(int i=1; i<list.length; i++){
				
				String currentElement = list[i];
				int j =i-1;
				//method getFirstIntToken() get the first numeric of the row
				//compare currentElement with the the one before
				while(j>=0 && datahandler.getFirstIntToken(list[j]).compareTo(datahandler.getFirstIntToken(currentElement))>0){
					list[j+1] = list[j];//move to the right 
					j--;
				}
				// Insert the current element into list[j+1]
				list[j+1] = currentElement;
			}
		}
	/**
	 * insertion sort any type of array 
	 * pre: the array unsorted 
	 * post: sorted array
	 * @param list - generic array
	 */
	public <T extends Comparable<T>> void insertionSort(T[] list){
		
		for(int i=1; i<list.length; i++){
			
			T currentElement = list[i];
			int j =i-1;
			//method getFirstIntToken() get the first numeric of the row
			//compare currentElement with the the one before
			while(j>=0 && list[j].compareTo(currentElement)>0){
				list[j+1] = list[j];//move to the right 
				j--;
			}
			// Insert the current element into list[j+1]
			list[j+1] = currentElement;
		}
	}
	
	public static void main(String[] args) throws IOException {
		InsertionSort insertionSort = new InsertionSort();
		//use run method from DataHandler cLass to run
		datahandler.run(insertionSort, args);
	}
}
