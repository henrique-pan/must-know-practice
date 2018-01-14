/* 

Quick Sort:
      Worst Case Performance: O(n^2)
      Best Case Performance: O(n log n)
      Average Performance: O(n log n)

    https://en.wikipedia.org/wiki/Quicksort
    https://www.youtube.com/watch?v=SLauY6PpjW4
    https://www.youtube.com/watch?v=PgBzjlCcFvc
    https://www.youtube.com/watch?v=aQiWF4E8flQ
*/

#include <stdio.h>
#include <stdlib.h>

void printArray(int array[], int length);
void quickSort(int array[], int initialIndex, int endIndex);

int main() {

	int array[] = {8, 3, 7, 5, 2, 10, 9, 1, 4, 6};
	int length = sizeof(array) / sizeof(array[0]);

	printf("Unsorted Array: \n");
	printArray(array, length);

	quickSort(array, 0, (length - 1));

	printf("Sorted Array: \n");
	printArray(array, length);	

	return 0;
}

void quickSort(int array[], int initialIndex, int endIndex) {
	if(initialIndex >= endIndex) {
		return;
	} else {
		int pivot = endIndex;
		int wallIndex = initialIndex;
		int currentIndex = initialIndex;

		// Separate lower to left and higher to rigth
		while(currentIndex < pivot) {
			if(array[currentIndex] < array[pivot]) {
				if(currentIndex != wallIndex) {
					int temp = array[currentIndex];
					array[currentIndex] = array[wallIndex];
					array[wallIndex] = temp;	
				}
				wallIndex++;
			}
			currentIndex++;
		}

		// Set pivot to its real location
		int temp = array[pivot];
		array[pivot] = array[wallIndex];
		array[wallIndex] = temp;	

		// Quick Sort Left Side
		quickSort(array, initialIndex, (wallIndex - 1);

		// Quick Sort Right Side
		quickSort(array, (wallIndex + 1), endIndex);
	}
}

void printArray(int array[], int length) {
	for(int i = 0; i < length; i++) {
		printf("%d ", array[i]);
	}
	printf("\n");
}