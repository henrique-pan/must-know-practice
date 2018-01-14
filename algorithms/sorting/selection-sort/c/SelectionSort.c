/* 

Selection Sort:
      Worst Case Performance: O(nˆ2)
      Best Case Performance: O(nˆ2)
      Average Performance: O(nˆ2)

      https://en.wikipedia.org/wiki/Selection_sort
*/ 

#include <stdio.h>

void printArray(int array[], int length);
void selectionSort(int array[], int length);

int main() {

  int array[] = {5, 1, 4, 3, 2, 10, 12, 9};
  int length = sizeof(array)/sizeof(array[0]);

  printf("Unsorted Array: \n");
  printArray(array, length);

  selectionSort(array, length);

  printf("Sorted Array: \n");
  printArray(array, length);

  return 0;
}

void printArray(int array[], int length) {
  for(int i = 0; i < length; i ++) {
    printf("%d ", array[i]);
  }
  printf("\n");
}

void selectionSort(int array[], int length) {
  int x = 0;

  while(x < length) {
    int smallElementIndex = x;
    int smallestValue = array[x];
    for (int i = (x + 1); i < length; i++)
    {
      if(array[i] < smallestValue) {
        smallElementIndex = i;
        smallestValue = array[i];
      }
    }

    int temp = array[x];
    array[x] = array[smallElementIndex];
    array[smallElementIndex] = temp;
    
    x++;
  }
}
