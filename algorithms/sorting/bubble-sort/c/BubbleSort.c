/* 

Bubble Sort:
      Worst Case Performance: O(nˆ2)
      Best Case Performance: O(n)
      Average Performance: O(nˆ2)

      https://en.wikipedia.org/wiki/Bubble_sort
      https://www.youtube.com/watch?v=TZRWRjq2CAg
*/ 

#include <stdio.h>
 
void bubbleSort(int array[], int n);
void printArray(int array[], int size);

int main()
{
    int array[] = {64, 34, 25, 12, 22, 11, 90};
    int n = sizeof(array)/sizeof(array[0]);

    printf("Unsorted array: \n");
    printArray(array, n);

    bubbleSort(array, n);

    printf("Sorted array: \n");
    printArray(array, n);

    return 0;
}

void bubbleSort(int array[], int n)
{
  while(n > 1) {
    for(int i = 0; i < (n - 1); i++) {
      if(array[i] > array[i + 1]) {
        int temp = array[i + 1];
        array[i + 1] = array[i];
        array[i] = temp;
      }
    }
    n--;
  }
} 

void printArray(int array[], int size)
{
    for (int i = 0; i < size; i++) {
      printf("%d ", array[i]);
    }
        
    printf("\n");
}
