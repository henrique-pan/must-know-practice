/* 

Counting Sort:
      Worst Case Performance: 
      Best Case Performance: 
      Average Performance: 

*/


var array = [8, 4, 2, 1, 5, 10, 6, 9, 7, 3]

console.log("Unsorted Array: ")
console.log(array)

countingSort(array)

console.log("Sorted Array: ")
console.log(array)

function countingSort(array) {
    // Find hisghest
    var highestElement = array[0]
    for(var i = 0; i < array.length; i++) {
        if(array[i] > highestElement) {
            highestElement = array[i]
        }
    }

    highestElement++
    // Creates counter
    var counter = []
    for(var i = 0; i < highestElement; i++) {
        counter[i] = 0
    }

    // Count
    for(var i = 0; i < array.length; i++) {
        counter[array[i]]++ 
    } 

    // Sort
    var index = 0
    for(var i = 0; i < highestElement; i++) {
        for(var j = 0; j < counter[i]; j++) {
            array[index++] = i
        }
    }

}


