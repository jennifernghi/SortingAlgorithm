import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * 
 * @author Nghi Nguyen
 * this class has composition relationship with other sorting classes
 * contains all methods use for handling data
 *
 */
public class DataHandler {
	/**
	 * generate random integer from 0 to 99
	 * @return random integer
	 */
	public int randomIntegerGenerator(){
		Random random = new Random();
		return random.nextInt(100);
	}
	/**
	 * generate an integer array with capacity n
	 * and fill it with random integer using randomIntegerGenerator()
	 * @param n - capacity of the array
	 * @return integer array with random integers
	 */
	public Integer[] integerArrayGenerator(int n){
		Integer[] array = new Integer[n];
		for (int i = 0; i<array.length; i++){
			array[i]=randomIntegerGenerator();
		}
		
		return array;
	}
	/**
	 * reads a text file, stores each line as a element in a string array
	 * @param filename - name of the data file
	 * @return string array
	 */
	public String[] fileToStringArray(String filename){
		ArrayList<String> data = new ArrayList<>();
		BufferedReader bufferedReader = null;
		String line;
		String[] list = new String[data.size()];
		try{
			try {
			
				bufferedReader = new BufferedReader(new FileReader(filename));
			} catch (FileNotFoundException e) {
			}
			
			try {
				while((line = bufferedReader.readLine()) != null){
					
					data.add(line.trim());// trim and add each line to arraylist data
				}
				
				list = new String[data.size()];
				data.toArray(list);//convert arraylist to array
			} catch (IOException e) {
				
			}
		}catch(Exception e){
			System.out.println("File not found.");
		}
			
		return list;
	}
	/**
	 * generic print method for any type of array - print the whole array 
	 * @param array - any array
	 */
	public <T> void print(T[] array){
		for(T a: array){
			System.out.print(a + " ");
		}
		System.out.println();
	}
	/**
	 * generic println method for any type of array - println the whole array 
	 * @param array - any array
	 */
	public <T> void println(T[] array){
		for(T a: array){
			System.out.println(a);
		}
		System.out.println();
	}

	/**
	 * extract the first numeric value of a string
	 * pre: the string in the format # name, ex: 10 anny
	 * post: return integer 10
	 * @param str - a string
	 * @return the first integer in str
	 */
	public Integer getFirstIntToken(String str){
		String firstNumber;
		Integer firstIntToken;
		if(str.indexOf(' ')>-1){ // if there is a space exist in str
			int i = str.indexOf(' ');// get first occurrence index of the space
			//get the substring from 0 to the space(exclusive) and assign it to firstNumber string
			firstNumber = str.substring(0, i);
			firstIntToken = Integer.parseInt(firstNumber);// get equal integer value of firstNumber  
			return firstIntToken;
		}
			return Integer.parseInt(str);
		
	}
	/**
	 * this method is used in sorting classes' main methods
	 * @param sortMethod Object type - object of the sorting class 
	 * @param args - string[] this is extra commands syntax
	 */
	public void run(Object sortMethod, String[] args){
		Scanner scanner;
		if(args.length ==1){ // using extra commands
			if(args[0].equals("sortintegerarray")){ 
				/**
				 * user input fixed size for integer array
				 * user input integer values
				 * the array is sorted using appropriate sorting classes
				 * the original and sorted array printed out
				 */
				scanner = new Scanner(System.in);
				
				System.out.print("Enter the size of the integer array: ");
				int size = scanner.nextInt();
				
				Integer[] array = new Integer[size];
				
				System.out.println("Enter data ( 1 integer each row): ");
				for(int i =0; i<array.length; i++){
					array[i] = scanner.nextInt();
				}
				scanner.close();
				
				System.out.println("Original: ");
				print(array);
				if(sortMethod instanceof InsertionSort){ //if sortMethod is a InsertionSort
					((InsertionSort) sortMethod).insertionSort(array);//sort the array
					System.out.println("Insertion sort:");
				}else if(sortMethod instanceof HeapSort){//if sortMethod is a HeapSort
					((HeapSort) sortMethod).heapSort(array);
					System.out.println("Heap sort:");
				}else if(sortMethod instanceof QuickSort){//if sortMethod is a QuickSort
					((QuickSort) sortMethod).quickSort(array);
					System.out.println("Quick sort:");
				}else if(sortMethod instanceof QuickSortRandomPivot){//if sortMethod is a QuickSortRandomPivot
					((QuickSortRandomPivot) sortMethod).quickSortRandomPivot(array);
					System.out.println("Quick sort random pivot:");
				}
				
				print(array);
			}else if(args[0].equals("sortstringarray")){
				/**
				 * user input fixed size for string array
				 * user input string values
				 * the array is sorted using appropriate sorting classes
				 * the original and sorted array printed out
				 */
				scanner = new Scanner(System.in);
				
				System.out.print("Enter the size of the string array: ");
				int size = scanner.nextInt();
				
				String[] array = new String[size];
				
				System.out.println("Enter string data ( 1 string each row): ");
				for(int i =0; i<array.length; i++){
					array[i] = scanner.next().trim();
				}
				scanner.close();
				
				System.out.println("Original: ");
				print(array);
				
				if(sortMethod instanceof InsertionSort){//if sortMethod is a InsertionSort
					((InsertionSort) sortMethod).insertionSort(array);//sort the array
					System.out.println("Insertion sort:");
				}else if(sortMethod instanceof HeapSort){//if sortMethod is a HeapSort
					((HeapSort) sortMethod).heapSort(array);
					System.out.println("Heap sort:");
				}else if(sortMethod instanceof QuickSort){//if sortMethod is a QuickSort
					((QuickSort) sortMethod).quickSort(array);
					System.out.println("Quick sort:");
				}else if(sortMethod instanceof QuickSortRandomPivot){//if sortMethod is a QuickSortRandomPivot
					((QuickSortRandomPivot) sortMethod).quickSortRandomPivot(array);
					System.out.println("Quick sort random pivot:");
				}
				
				print(array);
			}else{
				/**
				 * if a file name is passed in
				 * read the file then write the data into a string array using fileToStringArray(String filename)
				 * sort by using appropriate method
				 * print out original and sorted data 
				 */
				String[] data = fileToStringArray(args[0]);
				
			
				System.out.println("Original: ");
				for(int i=0; i<data.length; i++){
					System.out.println(data[i]);
				}
				
				if(sortMethod instanceof InsertionSort){//if sortMethod is a InsertionSort
					((InsertionSort) sortMethod).insertionSortForDataFile(data);//sort the array
					System.out.println("Insertion sort:");
				}else if(sortMethod instanceof HeapSort){//if sortMethod is a HeapSort
					((HeapSort) sortMethod).heapSortForDataFile(data);
					System.out.println("Heap sort:");
				}else if(sortMethod instanceof QuickSort){//if sortMethod is a QuickSort
					((QuickSort) sortMethod).quickSortForDataFile(data);
					System.out.println("Quick sort:");
				}else if(sortMethod instanceof QuickSortRandomPivot){//if sortMethod is a QuickSortRandomPivot
					((QuickSortRandomPivot) sortMethod).quickSortRandomPivotForDataFile(data);
					System.out.println("Quick sort random pivot:");
				}
				
				println(data);
				
			}
		}else if(args.length==0){
			/**
			 * get the running time of a sorting algorithm
			 * user input size of the array
			 * running time is printed out
			 */
			System.out.print("Enter total number of elements: ");
			scanner = new Scanner(System.in);
			int n = scanner.nextInt();
			Integer[] intArray = integerArrayGenerator(n);
			runningTime(sortMethod, intArray);
			scanner.close();
	
			
		}else{
			System.out.println("only 1 text file allowed."); // if user have more than 1 extra commands
		}
	}
	/**
	 * swap array[i] with array[j] in any type of array
	 * @param array - current array
	 * @param i - index 
	 * @param j - index
	 */
	public <T> void swap(T[] array, int i, int j){
		T temp = array[i];
		array[i] = array[j];
		array[j]= temp;
	}
	/**
	 * print out the running time of a sorting method
	 * @param sortMethod - object type
	 * @param array - generic array
	 */
	public <T extends Comparable<T>> void runningTime(Object sortMethod,T[] array){
		long startTime = System.currentTimeMillis();
		if(sortMethod instanceof InsertionSort){//if sortMethod is a InsertionSort
			((InsertionSort) sortMethod).insertionSort(array);//sort the array
		}else if(sortMethod instanceof HeapSort){//if sortMethod is a HeapSort
			((HeapSort) sortMethod).heapSort(array);
		}else if(sortMethod instanceof QuickSort){//if sortMethod is a QuickSort
			((QuickSort) sortMethod).quickSort(array);
			System.out.println("Quick sort:");
		}else if(sortMethod instanceof QuickSortRandomPivot){//if sortMethod is a QuickSortRandomPivot
			((QuickSortRandomPivot) sortMethod).quickSortRandomPivot(array);
			System.out.println("Quick sort random pivot:");
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Running time: "+ (endTime-startTime)+" milliseconds.");//print out
	}
}
