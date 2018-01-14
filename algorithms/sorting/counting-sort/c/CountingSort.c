/* 

Counting Sort:
      Worst Case Performance: 
      Best Case Performance: 
      Average Performance: 

*/
#include <stdio.h>
#include <stdlib.h>

void printArray(int array[], int length);
void countingSort(int array[], int length);


int main() {

  int array[] = {8, 3, 5, 10, 4, 9, 1, 2, 7, 6};
  int length = sizeof(array) / sizeof(array[0]);

  printf("Unsorted Array: \n");
  printArray(array, length);

  countingSort(array, length);

  printf("Sorted Array: \n");
  printArray(array, length);

  return 0;
}

void countingSort(int array[], int length) {
  // Find highest element
  int highestElement = array[0];
  for(int i = 0; i < length; i++) {
    if(array[i] > highestElement) {
      highestElement = array[i];
    }
  }

  // Creates Counter
  int counter[++highestElement];
  for(int i = 0; i < highestElement; i++) {
    counter[i] = 0;
  }

  for(int i = 0; i < length; i++) {
    counter[array[i]]++;
  }

  // Sort
  int index = 0;
  for(int i = 0; i < highestElement; i++){
    for(int j = 0; j < counter[i]; j++) {
      array[index++] = i;
    }
  }

}

void printArray(int array[], int length) {
  for (int i = 0; i < length; i++) {
    printf("%d ", array[i]);
  }
  printf("\n");
}
