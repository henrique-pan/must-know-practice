import Foundation

var array = [5,3,4,6,8,2,9,1,7,10,11]
var sortedArray = NSMutableArray(array: array)
var sortedAboveIndex = array.count
var swaps = 0

repeat {
    var lastSwapIndex = 0
    
    for i in 1..<sortedAboveIndex {
        if (sortedArray[i - 1] as! Int) > (sortedArray[i] as! Int) {
            sortedArray.exchangeObject(at: i, withObjectAt: i-1)
            lastSwapIndex = i
            swaps += 1
        }
    }
    
    sortedAboveIndex = lastSwapIndex
    
} while (sortedAboveIndex != 0)

// [5, 3, 4, 6, 8, 2, 9, 1, 7, 10, 11]
print(array)

// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
print(sortedArray as Array)

print("Array is sorted in \(swaps) swaps.")
