/* 

Radix Sort:
      Worst Case Performance: 
      Best Case Performance: 
      Average Performance: 

    https://www.geeksforgeeks.org/radix-sort/
    https://www.youtube.com/watch?v=XiuSW_mEn7g
    https://en.wikipedia.org/wiki/Radix_sort
*/

var array = [8, 3, 4, 10, 6, 9, 1, 2, 7]

console.log("Unsorted Array: ")
console.log(array)

radixSort(array)

console.log("Sorted Array: ")
console.log(array)

function radixSort(array) {
    // Find the highest element
    var max = array[0]
    for(var i = 1; i < array.length; i ++) {
        if(array[i] > max) {
            max = array[i]
        }
    }

    // For each exp, sort with countingSort
    for(var exp = 1; parseInt(max / exp) > 0; exp *= 10) {
        console.log("EXP: " + exp)
        countingSort(array, exp)
    }
}

function countingSort(array, exp) {
    var output = new Array(array.legnth)
    for(var i = 0; i < array.length; i++) {
        output[i] = 0
    }
    console.log("Output: " + output)

    var count = new Array(10)
    for(var i = 0; i < count.length; i++) {
        count[i] = 0
    }

    for(var i = 0; i < array.length; i++) {
        var index = parseInt(array[i] / exp) % 10
        count[index]++
    }
    console.log("Count: " + count)
    for(var i = 1; i < count.length; i++) {
        count[i] += count[i - 1]
    }
    console.log("Count: " + count)
    for(var i = array.length; i >= 0 ; i--) {
        var index = parseInt(array[i] / exp) % 10
        output[count[index] - 1] = array[i]
        count[index]--
    }

    for(var i = 0; i < array.length; i++) {
        console.log("ARRAY[i]" + array[i] + " OUTPUT[i]" + output[i])
        array[i] = output[i]
    }
    console.log(array)
}
