/* 

Comb Sort:
      Worst Case Performance: O(n^2)
      Best Case Performance: O(n)
      Average Performance: O(n^2)

      https://en.wikipedia.org/wiki/Comb_sort
      https://www.youtube.com/watch?v=n51GFZHXlYY
*/

console.log("CombSort");

var array = [8,3,2,4,6,10,9,7,1,5];

console.log("Unsorted Array: ");
console.log(array);

combSort(array);

console.log("Sorted Array: ");
console.log(array);


function combSort(array) {
    var shrinkFactor = 1.3;
    var gap = parseInt(array.length / shrinkFactor);

    while(gap >= 1) {
        var initialIndex = 0;
        var gapIndex = gap;
        while(gapIndex < array.length) {
            if(array[initialIndex] > array[gapIndex]) {
                var temp = array[initialIndex];
                array[initialIndex] = array[gapIndex];
                array[gapIndex] = temp;
            }
            initialIndex++;
            gapIndex++;
        }
        gap = parseInt(gap / shrinkFactor);
    }
}