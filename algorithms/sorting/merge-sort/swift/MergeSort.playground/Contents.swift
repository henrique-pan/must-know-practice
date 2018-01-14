import Foundation

func printArray(_ array: [Int]) {
    var result = ""
    for element in array {
        result += "\(element) "
    }
    print(result)
}

func mergeSort(_ array: [Int], _ initialIndex: Int, _ endIndex: Int) -> [Int] {
    if initialIndex == endIndex {
        return array
    } else {
        var sortedArray = NSMutableArray(array: array) as! [Int]

        let middle = Int((initialIndex + endIndex) / 2)

        let l = mergeSort(sortedArray, initialIndex, middle)
        let r = mergeSort(l, (middle + 1), endIndex)

        sortedArray = sort(r, initialIndex, middle, endIndex)
        return sortedArray
    }
}

func sort(_ array: [Int], _ initialIndex: Int, _ middle: Int, _ endIndex: Int) -> [Int] {
    var sortedArray = NSMutableArray(array: array) as! [Int]
    
    let leftSize = middle - initialIndex + 1
    let rightSize = endIndex - middle
    
    // Create Temp Left Array
    var leftArray: [Int] = []
    var t = initialIndex
    for i in 0 ... leftSize {
        leftArray.insert(sortedArray[t], at: i)
        t += 1
    }

    // Create Temp Right Array
    var rightArray: [Int] = [Int]()
    t = (middle + 1)
    for i in 0 ..< rightSize {
        rightArray.insert(sortedArray[t], at: i)
        t += 1
    }
    
    // Merge the arrays
    var leftIndex = 0
    var rightIndex = 0
    var arrayIndex = initialIndex
    while(leftIndex < leftSize && rightIndex < rightSize) {
        if leftArray[leftIndex] > rightArray[rightIndex] {
            sortedArray[arrayIndex] = rightArray[rightIndex]
            rightIndex += 1
        } else {
            sortedArray[arrayIndex] = leftArray[leftIndex]
            leftIndex += 1
        }
        arrayIndex += 1
    }
    
    // Put remainders in the left array
    while(leftIndex < leftSize) {
        sortedArray[arrayIndex] = leftArray[leftIndex]
        leftIndex += 1
        arrayIndex += 1
    }
    
    // Put remainders in the right array
    while(rightIndex < rightSize) {
        sortedArray[arrayIndex] = rightArray[rightIndex]
        rightIndex += 1
        arrayIndex += 1
    }
    
    return sortedArray
}

var array = [8, 2, 10, 6, 4, 5, 9, 7, 1, 3]

print("Unsorted Array: ")
printArray(array)

array = mergeSort(array, 0, (array.count - 1))

print("Unsorted Array: ")
printArray(array)





























