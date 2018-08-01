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

	public static void sortMin(int[] array) {
        int size = array.length;

        for(int i = (size/2) - 1; i >= 0; i--) {
            heapfyMin(array, i);
        }

        for(int i = 1; i < size; i++) {
            heapfyMin(array, i);
        }
    }

    public static void heapfyMin(int[] array, int ini) {
        int leftIndex = (ini * 2) + 1 - ini;
        int rightIndex = (ini * 2) + 2 - ini;
        int nextIndex = ini;

        if(leftIndex < array.length && array[nextIndex] > array[leftIndex]) {
            nextIndex = leftIndex;
        }

        if(rightIndex < array.length && array[nextIndex] > array[rightIndex]) {
            nextIndex = rightIndex;
        }

        if(nextIndex != ini) {
            int t = array[ini];
            array[ini] = array[nextIndex];
            array[nextIndex] = t;

            heapfyMin(array, nextIndex);
        }
    }

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

}