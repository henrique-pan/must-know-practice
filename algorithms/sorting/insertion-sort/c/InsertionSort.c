/* 

Insertion Sort:
      Worst Case Performance: O(nˆ2)
      Best Case Performance: O(n)
      Average Performance: O(nˆ2)

      https://en.wikipedia.org/wiki/Insertion_sort
      https://www.youtube.com/watch?v=TZRWRjq2CAg
*/ 

#include <stdio.h>

void printArray(int array[], int length);
void insertionSort(int array[], int length);

int main() {

  int array[] = {3, 2, 10, 9, 7, 5, 4};
  int length = sizeof(array)/sizeof(array[0]);

  printf("Unsorted Array: \n");
  printArray(array, length);

  insertionSort(array, length);

  printf("Sorted Array: \n");
  printArray(array, length);

  return 0;
}

void insertionSort(int array[], int length) {

  int x = 1;

  while(x < length) {
    for (int i = x; i > 0; i--)
    {
      if(array[i] < array[i - 1]) {
        int temp = array[i - 1];
        array[i - 1] = array[i];
        array[i] = temp; 
      }
    }
    x++;
  }
}

void printArray(int array[], int length) {
  for (int i = 0; i < length; ++i)
  {
    printf("%d ", array[i]);
  }
  printf("\n");
}
 
