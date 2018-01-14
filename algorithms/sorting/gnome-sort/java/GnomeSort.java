/* 

Gnome Sort:
      Worst Case Performance: 
      Best Case Performance: 
      Average Performance: 

    https://www.youtube.com/watch?v=43noNfrbEnQ
    https://en.wikipedia.org/wiki/Gnome_sort
*/

public class GnomeSort {

	public static void main(String[] args) {
		int[] array = {8, 3, 10, 1, 5, 4, 7, 6, 2, 9};

		System.out.println("Unsorted Array: ");
		printArray(array);

		gnomeSort(array);

		System.out.println("Sorted Array: ");
		printArray(array);
	}


	private static void gnomeSort(int[] array) {
		int currentIndex = 1;

		while(currentIndex < array.length) {
			int gnomeIndex = currentIndex;
			while(gnomeIndex > 0 && array[gnomeIndex] < array[gnomeIndex - 1]) {
				int temp = array[gnomeIndex];
				array[gnomeIndex] = array[gnomeIndex - 1];
				array[gnomeIndex - 1] = temp;

				gnomeIndex--;
			}
			currentIndex++;
		}
	}

	private static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		 System.out.println("");
	}
      
}


                  
   





