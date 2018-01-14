/* 

Counting Sort:
      Worst Case Performance: 
      Best Case Performance: 
      Average Performance: 

*/

public class CountingSort {

	public static void main(String[] args) {
		int[] array = {80, 3, 10, 21, 60, 1, 9, 76, 5, 4};

		System.out.println("Unsorted Array: ");
		printArray(array);

		bucketSort(array);

		System.out.println("Sorted Array: ");
		printArray(array);
	}


	private static void bucketSort(int[] array) {
		if(array != null && array.length >= 0) {
			// Find Highest
			int highestValue = array[0];
			for (int i = 1; i < array.length; i++) {
				if(array[i] > highestValue) {
					highestValue = array[i];
				}
			}

			// Create buckets
			int[] bucket = new int[highestValue + 1];
			for(int j = 0; j < array.length; j++) {
				bucket[array[j]]++;
			}

			// Sort
			int index = 0;
			for(int i = 0; i < bucket.length; i++) {
				for (int j = 0; j < bucket[i]; j++) {
					array[index++] = i;
				}
			}
		}
	}


	private static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
      
}


                  
   





