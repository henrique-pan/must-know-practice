/* 

Comb Sort:
      Worst Case Performance: O(n^2)
      Best Case Performance: O(n)
      Average Performance: O(n^2)

	  https://en.wikipedia.org/wiki/Comb_sort
      https://www.youtube.com/watch?v=n51GFZHXlYY
*/

public class CombSort {

	public static void main(String[] args) {
		int[] array = {8, 4, 1, 56, 3, -44, 23, -6, 28, 0};

		System.out.println("Unsorted Array: ");
		printArray(array);

		combSort(array);

		System.out.println("Sorted Array: ");
		printArray(array);
	}

	private static void combSort(int[] array) {
		float shrinkFactor = 1.3f;
		int gap = (int) (array.length / shrinkFactor);

		while(gap > 0) {
			
			for (int i = 0, j = gap; j < array.length; i++, j++) {
				if(array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}	

			gap = (int) (gap / shrinkFactor);
		}
	}	

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
	}

}

                  
   






