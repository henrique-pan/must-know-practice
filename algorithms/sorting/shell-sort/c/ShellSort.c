/* 

Shell Sort:
      Worst Case Performance: O(n^2)
      Best Case Performance: O(n)
      Average Performance: O(n^2)

    https://en.wikipedia.org/wiki/Shellsort
      https://www.youtube.com/watch?v=SHcPqUe2GZM
*/


#include <stdio.h>
#include <stdlib.h>

void printArray(int arra[], int length);
void shellSort(int arra[], int length);

int main() {

  int array[] = {8,3,2,4,6,10,9,7,1,5};
  int length = sizeof(array) / sizeof(array[0]);

  printf("Unsorted Array: \n");
  printArray(array, length);

  shellSort(array, length);

  printf("Sorted Array: \n");
  printArray(array, length);

  return 0;
}


void shellSort(int array[], int length) {
  int gap = (int) length / 2;

  while(gap > 0) {
    
    int gapIndex = gap - 1;
    while(gapIndex < length) {
      int i = gapIndex - gap;
      int j = gapIndex;

      while(i >= 0 && array[i] > array[j]) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        i -= gap;
        j -= gap;
      }

      gapIndex++;
    }

    gap = (int) gap / 2;
  }

}

void printArray(int array[], int length) {
  for(int i = 0; i < length; i++) {
    printf("%d ", array[i]);
  }
  printf("\n");
}