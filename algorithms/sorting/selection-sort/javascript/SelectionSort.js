/* 

Selection Sort:
      Worst Case Performance: O(nˆ2)
      Best Case Performance: O(nˆ2)
      Average Performance: O(nˆ2)

      https://en.wikipedia.org/wiki/Selection_sort
*/ 
var array = [3, 1, 98, 10, 4, 8, 7, 11];

console.log("Unsorted Array: ");
console.log(array);

selectionSort(array);

console.log("Unsorted Array: ");
console.log(array);

function selectionSort(array) {
    var x = 0;

    while(x < array.length) {
        var smallestElementIndex = x;
        var smallestElementValue = array[x];
        for (var i = x + 1; i < array.length; i++) {
            if(array[i] < smallestElementValue) {
                smallestElementIndex = i;
                smallestElementValue = array[i];
            }
        }

        var temp = array[x];
        array[x] = array[smallestElementIndex];
        array[smallestElementIndex] = temp;

        x++;
    }
}