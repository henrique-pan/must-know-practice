/* 

Bubble Sort:
      Worst Case Performance: O(nˆ2)
      Best Case Performance: O(n)
      Average Performance: O(nˆ2)

      https://en.wikipedia.org/wiki/Bubble_sort
*/ 

public class BubbleSort {

      public static void main(String[] args) {
            int[] array = {64, 34, 25, 12, 22, 11, 90};

            System.out.println("Unsorted Array: ");
            printArray(array);

            bubbleSort(array);

            System.out.println("Sorted Array: ");
            printArray(array);
      }

      public static void bubbleSort(int[] array) {
            int s = array.length;

            while(s > 1) {
                  for (int i = 0; i < (s - 1); i++) {
                        if(array[i] > array[i + 1]) {
                              int temp = array[i + 1];
                              array[i + 1] = array[i];
                              array[i] = temp;
                        }
                  }
                  s--;
            }
      }

      public static void bubbleSort2(int[] array) {
        for (int i = array.length-1; i >= 0 ; i--) {
            boolean isSorted = true;
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j+1]) {
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;

                    isSorted = false;
                }
            }
            if(isSorted) {
                System.out.println("The array is already sorted: i = " + i);
                return;
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