console.log("Merge Sort");

var array = [8, 3, 2, 1, 5, 10, 7, 6, 9, 4];

console.log("Unsorted Array: ");
console.log(array);

mergeSort(array, 0, (array.length - 1));

console.log("Sorted Array: ");
console.log(array);

function mergeSort(array, initialIndex, endIndex) {
    if(initialIndex == endIndex) {
        return;
    } else {
        var middle = parseInt((initialIndex + endIndex) / 2);

        // Split Left Side
        mergeSort(array, initialIndex, middle);

        // Split Right Side
        mergeSort(array, (middle + 1), endIndex);

        sort(array, initialIndex, middle, endIndex);
    }
}

function sort(array, initialIndex, middle, endIndex) {
    var leftSize = (middle - initialIndex) + 1;
    var rightSize = endIndex - middle;

    var leftArray = [];
    for (var i = initialIndex, j = 0; i <= middle; i++, j++) {
        leftArray[j] = array[i];   
    }

    var rightArray = [];
    for (var i = (middle + 1), j = 0; i <= endIndex; i++, j++) {
        rightArray[j] = array[i];   
    }

    var leftIndex = 0;
    var rightIndex = 0;
    var arrayIndex = initialIndex;

    while(leftIndex < leftSize && rightIndex < rightSize) {
        if(leftArray[leftIndex] < rightArray[rightIndex]) {
            array[arrayIndex] = leftArray[leftIndex];
            leftIndex++;
        } else {
            array[arrayIndex] = rightArray[rightIndex];
            rightIndex++;
        }
        arrayIndex++;
    }

    while(leftIndex < leftSize) {
        array[arrayIndex] = leftArray[leftIndex];
        leftIndex++;
        arrayIndex++;
    }

    while(rightIndex < rightIndex) {
        array[arrayIndex] = rightArray[rightIndex];
        rightIndex++;
        arrayIndex++;
    }

}


