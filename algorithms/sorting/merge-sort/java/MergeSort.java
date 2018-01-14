/* 

Merge Sort:
      Worst Case Performance: 
      Best Case Performance: 
      Average Performance: 

      https://en.wikipedia.org/wiki/Merge_sort
      https://www.youtube.com/watch?v=JSceec-wEyw
      https://www.youtube.com/watch?v=es2T6KY45cA
*/

public class MergeSort {

	public static void main(String[] args) {
		int[] array = { 7, 3, 5, 4, 10, 9, 8 };
		System.out.println("Unsorted Array: ");
		printArray(array);

		mergeSort(array, 0, (array.length - 1));

		System.out.println("Sorted Array: ");
		printArray(array);
	}

	private static void mergeSort(int[] array, int initialIndex, int endIndex) {
		if (initialIndex == endIndex) {
			return;
		} else {
			int middle = (initialIndex + endIndex) / 2;

			// Split Left Side
			mergeSort(array, initialIndex, middle);

			// Split Right Side
			mergeSort(array, (middle + 1), endIndex);

			// Sort when there is no element either to right or left
			sort(array, initialIndex, middle, endIndex);
		}
	}

	private static void sort(int[] array, int initialIndex, int middle, int endIndex) {
		// Get the size of the temp arrays
		int leftSize = middle - initialIndex + 1;
		int rightSize = endIndex - middle;

		// Creates the left temp array
		int[] leftArray = new int[leftSize];
		for (int i = initialIndex, j = 0; i <= middle; i++, j++) {
			leftArray[j] = array[i];
		}

		// Creates the right temp array
		int[] rightArray = new int[rightSize];
		for (int i = (middle + 1), j = 0; i <= endIndex; i++, j++) {
			rightArray[j] = array[i];
		}		
		
		// Sort doing the merge
		int leftIndex = 0;
		int rightIndex = 0;		
		int arrayIndex = initialIndex;
		
		// Compare elements from left to elements from right
		while(leftIndex < leftSize && rightIndex < rightSize) {
			if(leftArray[leftIndex] < rightArray[rightIndex]) {
				array[arrayIndex] = leftArray[leftIndex];
				leftIndex++;
			} else {
				array[arrayIndex] = rightArray[rightIndex];
				rightIndex++;
			}			
			arrayIndex++;
		}
		
		// Set remainder values from left
		while(leftIndex < leftSize) {
			array[arrayIndex] = leftArray[leftIndex];
			leftIndex++;
			arrayIndex++;
		}
		
		// Set remainder values from right
		while(rightIndex < rightSize) {
			array[arrayIndex] = rightArray[rightIndex];
			rightIndex++;
			arrayIndex++;
		}
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

}

