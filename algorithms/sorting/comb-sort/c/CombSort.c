/* 

Comb Sort:
      Worst Case Performance: O(n^2)
      Best Case Performance: O(n)
      Average Performance: O(n^2)

    https://en.wikipedia.org/wiki/Comb_sort
      https://www.youtube.com/watch?v=n51GFZHXlYY
*/

#include <stdio.h>
#include <stdio.h>

void printArray(int array[], int length);
void combSort(int array[], int length);

int main() {

  int array[] = {8, 3, 2, 4, 6, 10, 9, 7, 1, 5};
  int length = sizeof(array)/sizeof(array[0]);

  printf("Unsorted Array: \n");
  printArray(array, length);

  combSort(array, length);

  printf("Sorted Array: \n");
  printArray(array, length);

  return 0;
}
 
void combSort(int array[], int length) {
  float shrinkFactor = 1.3;
  int gap = (int) length / shrinkFactor;

  while(gap >= 1) {
    int initialIndex = 0;
    int gapIndex = gap;
    while(gapIndex < length) {
      if(array[initialIndex] > array[gapIndex]) {
        int temp = array[initialIndex];
        array[initialIndex] = array[gapIndex];
        array[gapIndex] = temp;
      }
      initialIndex++;
      gapIndex++;
    }
    gap = (int) gap / shrinkFactor;
  }

}

void printArray(int array[], int length) {
  for(int i = 0; i < length; i++) {
    printf("%d ", array[i]);
  }
  printf("\n");
}
