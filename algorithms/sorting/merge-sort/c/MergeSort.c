#include <stdio.h>
#include <stdlib.h>

void printArray(int array[], int length);
void mergeSort(int array[], int initialIndex, int endIndex);
void sort(int array[], int initialIndex, int middle, int endIndex);

int main() {
  int array[] = {8, 3, 2, 1, 5, 10, 7, 6, 9, 4};
  int length = sizeof(array)/sizeof(array[0]);

  printf("Unsorted Array: ");
  printArray(array, length);
  
  mergeSort(array, 0, (length - 1));

  printf("Sorted Array: ");
  printArray(array, length);

  return 0;
}


void mergeSort(int array[], int initialIndex, int endIndex) {
  if(initialIndex == endIndex) {
    return;
  } else {
    int middle = (initialIndex + endIndex) / 2;

    // Split Left Side
    mergeSort(array, initialIndex, middle);

    // Split Right Side
    mergeSort(array, (middle + 1), endIndex);

    // Sort split results
    sort(array, initialIndex, middle, endIndex);
  }
}

void sort(int array[], int initialIndex, int middle, int endIndex) {
  int leftSize = middle - initialIndex + 1;
  int rightSize = endIndex - middle;

  int leftArray[leftSize];
  for(int i = initialIndex, j = 0; i <= middle; i++, j++) {
    leftArray[j] = array[i];
  }

  int rightArray[rightSize];
  for(int i = (middle + 1), j = 0; i <= endIndex; i++, j++) {
    rightArray[j] = array[i];
  }

  int i = 0;
  int j = 0;
  int arrayIndex = initialIndex;

  while(i < leftSize && j < rightSize) {
    if(leftArray[i] < rightArray[j]) {
      array[arrayIndex] = leftArray[i];
      i++;
    } else {
      array[arrayIndex] = rightArray[j];
      j++;
    }
    arrayIndex++;
  }

  while(i < leftSize) {
    array[arrayIndex] = leftArray[i];
    i++;
    arrayIndex++;
  }

  while(j < rightSize) {
      array[arrayIndex] = rightArray[j];
      j++;
      arrayIndex++;    
  }
}


void printArray(int array[], int length) {
  for(int i = 0; i < length; i++) {
    printf("%d ", array[i]);
  }
  printf("\n");
}