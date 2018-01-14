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

var array = [8 , 1, 3, 5, 10, 9, 7, 4, 2]

console.log("Unsorted Array: ")
console.log(array)

quickSort(array, 0 , array.length - 1)

console.log("Unsorted Array: ")
console.log(array)


function quickSort(array, initialIndex, endIndex) {
	if(initialIndex >= endIndex) {
		return
	} else {
		var pivot = endIndex
		var wallIndex = initialIndex
		var currentIndex = initialIndex

		// Separate lower to the left and higher to the right
		while(currentIndex < endIndex) {
			if(array[currentIndex] < array[pivot]) {
				if(currentIndex != wallIndex) {
					var temp = array[currentIndex]
					array[currentIndex] = array[wallIndex]
					array[wallIndex] = temp
				}
				wallIndex++
			}
			currentIndex++
		}

		// Set pivot in the real position
		var temp = array[pivot]
		array[pivot] = array[wallIndex]
		array[wallIndex] = temp

		// Quick sort left side
		quickSort(array, initialIndex, wallIndex - 1);

		// Quick sort right side
		quickSort(array, wallIndex + 1, endIndex);		

	}
}