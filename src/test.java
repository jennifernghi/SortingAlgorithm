
public class test {

	public static void main(String[] args) {
		DataHandler dataHandler = new DataHandler();
		InsertionSort insertionSort = new InsertionSort();
		HeapSort heapSort = new HeapSort();
		QuickSort quickSort = new QuickSort();
		Integer[] data = dataHandler.integerArrayGenerator(15);
		for(Integer d: data){
			System.out.print(d + " ");
		}
		System.out.println();
		System.out.println("Insertion:");
		insertionSort.insertionSort(data);
		for(Integer d: data){
			System.out.print(d + " ");
		}
		System.out.println();
		System.out.println("-----------------");
		Integer[] data2 = dataHandler.integerArrayGenerator(15);
		for(Integer d: data2){
			System.out.print(d + " ");
		}
		System.out.println();
		System.out.println("Heap:");
		heapSort.heapSort(data2);
		for(Integer d: data2){
			System.out.print(d + " ");
		}
		System.out.println();
		System.out.println("-----------------");
		Integer[] data3 = dataHandler.integerArrayGenerator(15);
		for(Integer d: data3){
			System.out.print(d + " ");
		}
		System.out.println("quick:");
		
		quickSort.quickSort(data3);
		for(Integer d: data3){
			System.out.print(d + " ");
		}
		
		
	}

}
