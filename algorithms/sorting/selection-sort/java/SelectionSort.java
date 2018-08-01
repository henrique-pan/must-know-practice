/* 

Selection Sort:
      Worst Case Performance: O(nˆ2)
      Best Case Performance: O(nˆ2)
      Average Performance: O(nˆ2)

      https://en.wikipedia.org/wiki/Selection_sort
*/ 

public class SelectionSort {

	public static void main(String[] args) {
		int[] array = {4, 6, 1, 3, 10, 12, 2};

		System.out.println("Unsorted Array: ");
		printArray(array);

		selectionSort(array);

		System.out.println("Sorted Array: ");
		printArray(array);
	}


	private static void selectionSort(int[] array) {
		int x = 0;

		while(x < array.length) {
			int smallestIndex = x;
			int smallest = array[x];
			for(int i = x; i < (array.length - 1); i++) {
				if(array[i + 1] < smallest) {
					smallestIndex = (i + 1);
					smallest = array[i + 1];
				}
			}

			if(smallestIndex != x) {
				int temp = array[x];
				array[x] = array[smallestIndex];
				array[smallestIndex] = temp; 
			}

			x++;
		}
	}

	public static void selectionSort2(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int lowerIndex = i;
            for (int j = i; j < array.length; j++) {
                if(i != j && array[j] < array[lowerIndex]) {
                    lowerIndex = j;
                }
            }
            if(i != lowerIndex) {
                int t = array[i];
                array[i] = array[lowerIndex];
                array[lowerIndex] = t;
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


                  
   





