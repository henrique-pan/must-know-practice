/* 

Insertion Sort:
      Worst Case Performance: O(nˆ2)
      Best Case Performance: O(n)
      Average Performance: O(nˆ2)

      https://en.wikipedia.org/wiki/Insertion_sort
      https://www.youtube.com/watch?v=TZRWRjq2CAg
*/ 

var array = [3, 6, 1, 10, 9, 7, 8, 4];

console.log("Unsorted Array: ");
console.log(array);

insertionSort(array);

console.log("Sorted Array: ");
console.log(array);

function insertionSort(array) {
    var x = 1;

    while(x < array.length) {
        for (var i = x; i > 0; i--) {
            if(array[i] < array[i - 1]) {
                var temp = array[i - 1];
                array[i - 1] = array[i];
                array[i] = temp;
            }
        }
        x++;
    }
}