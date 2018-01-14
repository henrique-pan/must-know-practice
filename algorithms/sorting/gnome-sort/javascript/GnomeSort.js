/* 

Gnome Sort:
      Worst Case Performance: 
      Best Case Performance: 
      Average Performance: 

    https://www.youtube.com/watch?v=43noNfrbEnQ
    https://en.wikipedia.org/wiki/Gnome_sort
*/

var array = [8 , 4, 5, 10, 2, 3, 9, 6, 7, 1];

console.log("Unsorted Array: ")
console.log(array)

gnomeSort(array)

console.log("Sorted Array: ")
console.log(array)


function gnomeSort(array) {
    var currentIndex = 1

    while(currentIndex < array.length) {
        var gnomeIndex = currentIndex
        while(gnomeIndex > 0 && array[gnomeIndex] < array[gnomeIndex - 1]) {
            var temp = array[gnomeIndex]
            array[gnomeIndex] = array[gnomeIndex - 1]
            array[gnomeIndex - 1] = temp

            gnomeIndex--
        }
        currentIndex++
    }
}