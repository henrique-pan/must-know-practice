/* 

Shell Sort:
      Worst Case Performance: O(n^2)
      Best Case Performance: O(n)
      Average Performance: O(n^2)

	  https://en.wikipedia.org/wiki/Shellsort
      https://www.youtube.com/watch?v=SHcPqUe2GZM
*/

public class ShellSort {

	public static void main(String[] args) {
		int[] array = {8, 2, 10, 1, 5, 7, 6, 9, 4, 3};

		System.out.println("Unsorted Array: ");
		printArray(array);

		shellSort(array);

		System.out.println("Sorted Array: ");
		printArray(array);
	}


	private static void shellSort(int[] array) {
		int gap = array.length / 2;

		while(gap > 0) {
			int gapIndex = (gap - 1);
			while(gapIndex < array.length) {
				int i = (gapIndex - gap), j = gapIndex;				
				while(i >= 0 && array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					i -= gap;
					j -= gap; 
				}
				gapIndex++;
			}
			gap = gap/2;
		}
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}   
}


                  
   





