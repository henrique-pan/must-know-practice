/* 

Heap Sort:
      Worst Case Performance: 
      Best Case Performance: 
      Average Performance: 

    https://www.geeksforgeeks.org/heap-sort/
    https://en.wikipedia.org/wiki/Heapsort
    https://www.youtube.com/watch?v=MtQL_ll5KhQ
    https://www.youtube.com/watch?v=t0Cq6tVNRBA
    https://www.youtube.com/watch?v=QdRL3XLyiVc
*/

public class HeapSort {

	public static void main(String args[]) {
		int array[] = {8, 5, 2, 10, 7, 6, 9, 1, 4, 3};

		System.out.println("Unsorted Array: ");
		printArray(array);

		heapSort(array);

		System.out.println("Sorted Array: ");
		printArray(array);
	}

	private static void heapSort(int[] array) {
		int length = array.length;

		for (int i = length / 2 - 1; i >= 0; i--) {
			heapify(array, length, i);
		}

		for (int i = (length - 1); i > 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;

			heapify(array, i, 0);
		}
	}

	private static void heapify(int array[], int length, int rootIndex) {
		int largest = rootIndex;
		int leftIndex = 2 * rootIndex + 1;
		int rightIndex = 2 * rootIndex + 2;

		if (leftIndex < length && array[leftIndex] > array[largest]) {
			largest = leftIndex;
		}

		if (rightIndex < length && array[rightIndex] > array[largest]) {
			largest = rightIndex;
		}

		if (largest != rootIndex) {
			int temp = array[rootIndex];
			array[rootIndex] = array[largest];
			array[largest] = temp;

			heapify(array, length, largest);
		}
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

}