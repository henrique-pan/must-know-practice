/* 

Shell Sort:
      Worst Case Performance: O(n^2)
      Best Case Performance: O(n)
      Average Performance: O(n^2)

      https://en.wikipedia.org/wiki/Shellsort
      https://www.youtube.com/watch?v=SHcPqUe2GZM
*/
console.log("Shell Sort")

var array = [8,3,2,4,6,10,9,7,1,5]

console.log("Unsorted Array: ")
console.log(array)

shellSort(array)

console.log("Unsorted Array: ")
console.log(array)

function shellSort(array) {
    var gap = parseInt(array.length / 2)

    while(gap > 0) {
        var initialIndex = 0;
        var gapIndex = gap;
        while(gapIndex <= array.length) {
            var initialIndex = gapIndex - gap;
            var j = gapIndex
            while(initialIndex >= 0 && array[initialIndex] > array[j]) {
                var temp = array[initialIndex]
                array[initialIndex] = array[j]
                array[j] = temp

                initialIndex -= gap
                j -= gap
            }

            gapIndex++;
        }

        gap = parseInt(gap / 2)
    }

}