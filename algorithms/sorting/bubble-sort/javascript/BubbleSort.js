var array = [ -1 , -9 , 8 , 5 , 6 , 4 , 6 ];

console.log("Unsorted array: " + array);
console.log(array);

bubbleSort(array);

console.log("Sorted Array: ");
console.log(array);

function bubbleSort(array){
    var s = array.length;

    while(s > 1) {
        for (var i = 0; i < (s - 1); i++) {
            if(array[i] > array[i + 1]) {
                var temp = array[i + 1];
                array[i + 1] = array[i];
                array[i] = temp;
            }
        }
        s--;
    }
}