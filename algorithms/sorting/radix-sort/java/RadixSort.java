/* 

Radix Sort:
      Worst Case Performance: 
      Best Case Performance: 
      Average Performance: 

    https://www.geeksforgeeks.org/radix-sort/
    https://www.youtube.com/watch?v=XiuSW_mEn7g
    https://en.wikipedia.org/wiki/Radix_sort
*/

public class RadixSort {

	public static void main(String[] args) {
		int array[] = {9, 5, 4, 3, 2, 10}; //{ 170, 45, 75, 90, 802, 24, 2, 66 };

		System.out.println("Unsorted Array: ");
		printArray(array);

		radixsort(array);

		System.out.println("Sorted Array: ");
		printArray(array);
	}

	private static void radixsort(int array[]) {
		int mx = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > mx) {
				mx = array[i];
			}
		}

		for (int exp = 1; (mx / exp) > 0; exp *= 10) {
			countSort(array, exp);
		}
	}

	private static void countSort(int array[], int exp) {
		int length = array.length;

		int output[] = new int[length];
		int count[] = new int[10];

		for (int i = 0; i < length; i++) {
			int index = (array[i] / exp) % 10;
			count[index]++;
		}

		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		for (int i = length - 1; i >= 0; i--) {
			int index = (array[i] / exp) % 10;
			output[count[index] - 1] = array[i];
			count[index]--;
		}

		for (int i = 0; i < length; i++) {
			array[i] = output[i];
		}
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

}