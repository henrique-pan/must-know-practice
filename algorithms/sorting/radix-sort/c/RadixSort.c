/* 

Radix Sort:
      Worst Case Performance: 
      Best Case Performance: 
      Average Performance: 

    https://www.geeksforgeeks.org/radix-sort/
    https://www.youtube.com/watch?v=XiuSW_mEn7g
    https://en.wikipedia.org/wiki/Radix_sort
*/

#include <stdio.h>

void printArray(int array[], int length);
void radixSort(int array[], int length);
void countingSort(int array[], int length, int exp);

int main() {

  int array[] = {9, 5, 4, 3, 2, 10};//{170, 45, 75, 90, 802, 24, 2, 66};
  int length = sizeof(array) / sizeof(array[0]);

  printf("Unsorted Array: \n");
  printArray(array, length);

  radixSort(array, length);

  printf("Sorted Array: \n");
  printArray(array, length);

  return 0;
}

void radixSort(int array[], int length) {
  //Find the max element
  int max = array[0];
  for(int i = 1; i < length; i++) {
    if(array[i] > max) {
      max = array[i];
    }
  }

  // Sort with counting sort for each existent exp 
  for(int exp = 1; (max / exp) > 0; exp *= 10) {
    countingSort(array, length, exp);
  }
}

void countingSort(int array[], int length, int exp) {
  
  int output[length];

  int count[10];
  for(int i = 0; i < 10; i++) {
    count[i] = 0;
  }

  for(int i = 0; i < length; i++) {
    int index = (array[i] / exp) % 10;
    count[index]++;
  }

  for(int i = 1; i < 10; i++) {
    count[i] += count[i - 1];
  }

  for(int i = (length - 1); i >= 0; i--) {
    int index = (array[i] / exp) % 10;
    output[count[index] - 1] = array[i];
    count[index]--;
  }

  for(int i = 0; i < length; i++) {
    array[i] = output[i];
  }

}

void printArray(int array[], int length) {
  for(int i = 0; i < length; i++) {
    printf("%d ", array[i]);
  }
  printf("\n");
}
