/* 

Insertion Sort:
      Worst Case Performance: O(nˆ2)
      Best Case Performance: O(n)
      Average Performance: O(nˆ2)

      https://en.wikipedia.org/wiki/Insertion_sort
      https://www.youtube.com/watch?v=TZRWRjq2CAg
*/ 

public class InsertionSort {

      public static void main(String[] args) {

      	int[] array = {7, 3, 8, 2, 9, 1, 20, 10};

      	System.out.println("Unsorted Array: ");
      	printArray(array);

      	insertionSort(array);

      	System.out.println("Sorted Array: ");
      	printArray(array);

      }

      private static void insertionSort(int[] array) {
      	int x = 1;
      	while(x < array.length) {
      		for (int i = x; i > 0; i--) {
      			if(array[i] < array[i - 1]) {
      				int temp = array[i];
      				array[i] = array[i - 1];
      				array[i - 1] = temp;
      			}
      		}
      		x++;
      	}
      }

      public static void insertionSort2(int[] array) {
        for (int i = 1; i <= array.length - 1; i++) {
            int pivot = i;
            for (int j = i - 1; j >= 0; j--) {
                if(array[pivot] < array[j]) {
                    int t = array[pivot];
                    array[pivot] = array[j];
                    array[j] = t;

                    pivot--;
                } else {
                    break;
                }
            }
        }
    }

    public static void insertionSort3(int[] array) {
        for (int i = 1; i <= array.length - 1; i++) {
            int pivot = i;
            int j = i - 1;
            while(j >= 0 && array[pivot] < array[j]) {
                int t = array[pivot];
                array[pivot--] = array[j];
                array[j--] = t;
            }
        }
    }


      private static void printArray(int[] array) {
      	for (int i = 0; i < array.length; i++) {
      		System.out.print(array[i] + " ");	
      	}
      	System.out.println("");
      }
}


                  
   





