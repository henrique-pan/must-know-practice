/* 

Quick Sort:
      Worst Case Performance: O(n^2)
      Best Case Performance: O(n log n)
      Average Performance: O(n log n)

    https://en.wikipedia.org/wiki/Quicksort
    https://www.youtube.com/watch?v=SLauY6PpjW4
    https://www.youtube.com/watch?v=PgBzjlCcFvc
    https://www.youtube.com/watch?v=aQiWF4E8flQ
*/

public class QuickSort {

	public static void main(String args[]) {
		int[] array = {8, 3, 7, 5, 2, 10, 9, 6, 4, 1};

		System.out.println("Unsorted Array: ");
		printArray(array);

		quickSort(array, 0, (array.length - 1));

		System.out.println("Sorted Array: ");
		printArray(array);
	}


	private static void quickSort(int[] array, int initialIndex, int endIndex) {
		if(initialIndex >= endIndex) {
			return;
		} else {
			int pivot = endIndex;

			int wallIndex = initialIndex;
			int currentIndex = initialIndex;

			while(currentIndex < pivot) {
				if(array[currentIndex] < array[pivot]) {
					if(currentIndex != wallIndex) {
						int temp = array[currentIndex];
						array[currentIndex] = array[wallIndex];
						array[wallIndex] = temp;
					}
					wallIndex++;
				} 
				currentIndex++;
			}

			// Swap pivot
			int temp = array[pivot];
			array[pivot] = array[wallIndex]; 
			array[wallIndex] = temp;

			// Quick Sort Left
			quickSort(array, initialIndex, (wallIndex - 1));
			// Quick Sort Right
			quickSort(array, (wallIndex + 1), endIndex);
		}
	}


	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
      
}


                  
   





