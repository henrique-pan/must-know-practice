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

var array = [9, 7 , 2, 10, 3 , 5, 1, 6, 4, 8]

console.log("Unsorted Array: ")
console.log(array)

heapSort(array)

console.log("Sorted Array: ")
console.log(array)

function heapSort(array) {
	var n = parseInt(array.length / 2) - 1
	for(var i = n; i >= 0; i--) {
		heapfy(array, array.length, i)
	}

	var currentIndex = (array.length - 1)
	while(currentIndex > 0) {
		var temp = array[0]
		array[0] = array[currentIndex]
		array[currentIndex] = temp

		heapfy(array, currentIndex, 0)

		currentIndex--
	}

}

function heapfy(array, length, rootIndex) {
	var largestIndex = rootIndex
	var leftIndex = rootIndex * 2 + 1
	var rightIndex = rootIndex * 2 + 2

	if(leftIndex < length && array[leftIndex] > array[largestIndex]) {
		largestIndex = leftIndex
	}

	if(rightIndex < length && array[rightIndex] > array[largestIndex]) {
		largestIndex = rightIndex
	}

	if(largestIndex != rootIndex) {
		var temp = array[largestIndex]
		array[largestIndex] = array[rootIndex]
		array[rootIndex] = temp

		heapfy(array, length, largestIndex)
	}
}