/* 

Gnome Sort:
      Worst Case Performance: 
      Best Case Performance: 
      Average Performance: 

    https://www.youtube.com/watch?v=43noNfrbEnQ
    https://en.wikipedia.org/wiki/Gnome_sort
*/

#include <stdio.h>

void printArray(int array[], int length);
void gnomeSort(int array[], int length);

int main() {

  int array[] = {8, 4, 1, 5, 10, 7, 9, 6, 2};
  int length = sizeof(array) / sizeof(array[0]);

  printf("Unsorted Array: \n");
  printArray(array, length);

  gnomeSort(array, length);

  printf("Sorted Array: \n");
  printArray(array, length);

  return 0;
}

void gnomeSort(int array[], int length) {
  int currentIndex = 1;

  while(currentIndex < length) {
    int gnomeIndex = currentIndex;
    while(gnomeIndex > 0 && array[gnomeIndex] < array[gnomeIndex - 1]) {
      int temp = array[gnomeIndex];
      array[gnomeIndex] = array[gnomeIndex - 1];
      array[gnomeIndex - 1] = temp;

      gnomeIndex--;
    }
    currentIndex++;
  }

}

void printArray(int array[], int length) {
  for(int i = 0; i < length; i++) {
    printf("%d ", array[i]);
  }
  printf("\n");
}