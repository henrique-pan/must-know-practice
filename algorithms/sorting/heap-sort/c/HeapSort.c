/* 

Heap Sort:
      Worst Case Performance: 
      Best Case Performance: 
      Average Performance: 

    https://www.geeksforgeeks.org/heap-sort/
    https://en.wikipedia.org/wiki/Heapsort
    https://www.youtube.com/watch?v=MtQL_ll5KhQ
    https://www.youtube.com/watch?v=t0Cq6tVNRBA
    https://www.youtube.com/watch?v=QdRL3XLyiVc
*/
    
#include <stdio.h>

void printArray(int array[], int length);
void heapSort(int array[], int length);
void heapfy(int array[], int length, int root);

int main() {

	int array[] = {9, 3, 7, 10 ,5, 2, 1, 6, 4, 8};
	int length = sizeof(array) / sizeof(array[0]);

	printf("Unsorted Array: \n");
	printArray(array, length);

	heapSort(array, length);

	printf("Sorted Array: \n");
	printArray(array, length);

	return 0;
}

void heapSort(int array[], int length) {
	int n = (length / 2) - 1;
	for(int i = n; i >= 0; i--) {
		heapfy(array, length, i);
	}

	int currentIndex = (length - 1);
	while(currentIndex > 0) {
		int temp = array[currentIndex];
		array[currentIndex] = array[0];
		array[0] = temp;

		heapfy(array, currentIndex, 0);
		currentIndex--;
	}
}


void heapfy(int array[], int length, int root) {
	int largest = root;
	int leftChild = root * 2 + 1;
	int rightChild = root * 2 + 2;

	if(leftChild < length && array[leftChild] > array[largest]) {
		largest = leftChild;
	}

	if(rightChild < length && array[rightChild] > array[largest]) {
		largest = rightChild;	
	}

	if(largest != root) {
		int temp = array[largest];
		array[largest] = array[root];
		array[root] = temp;

		heapfy(array, length, largest);
	}
}


void printArray(int array[], int length) {
	for(int i = 0; i < length; i++) {
		printf("%d ", array[i]);
	}
	printf("\n");
}