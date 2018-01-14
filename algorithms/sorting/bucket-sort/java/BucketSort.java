import java.util.*;
/* 

Bucket Sort:

*/

public class BucketSort {

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

			// Create buckets
			/* "You cannot create arrays of parameterized types"

			List<Integer>[] buckets = new ArrayList<Integer>[10];
			*/
			List<List<Integer>> buckets = new ArrayList<List<Integer>>(10);
			for(int i = 0; i < 10; i++) {
				buckets.add(new ArrayList<Integer>());
			}

			for(int i = 0; i < array.length; i++) {
				int hash = hash(array[i]);

				List<Integer> bucket = buckets.get(hash);
				bucket.add(array[i]);
			}

			// Sort
			for(int i = 0; i < buckets.size(); i++) {
				List<Integer> bucket = buckets.get(i);
				if(bucket != null) {
					Collections.sort(bucket);
				}
			}

			// Set to final array
			int index = 0;
			for(int i = 0; i < buckets.size(); i++) {
				List<Integer> bucket = buckets.get(i);
				for (int j = 0; j < bucket.size(); j++) {
					array[index++] = bucket.get(j);
				}
			}
		}
	}

	private static int hash(int number) {
		if(number < 10) {
			return 0;
		}
		String s = number + "";
		return Character.getNumericValue(s.charAt(0));
	}

	private static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
      
}


                  
   





