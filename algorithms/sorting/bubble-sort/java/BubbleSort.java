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

      static void bubbleSort(int[] array) {
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

      private static void printArray(int[] array) {
            for (int i = 0; i < array.length; i++) {
                  System.out.print(array[i] + " ");
            }
            System.out.println("");
      }     
}