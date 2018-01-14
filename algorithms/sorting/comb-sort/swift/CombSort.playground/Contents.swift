/*
 
 Comb Sort:
 Worst Case Performance: O(n^2)
 Best Case Performance: O(n)
 Average Performance: O(n^2)
 
 https://en.wikipedia.org/wiki/Comb_sort
 https://www.youtube.com/watch?v=n51GFZHXlYY
 */

import Foundation

func printArray(_ array: [Int]) {
    var result = ""
    for n in array {
        result += "\(n) "
    }
    print(result)
}

func combSort(_ array: [Int]) -> [Int] {
    var sortedArray = NSMutableArray(array: array) as! [Int]
    
    let shrinkFactor = 1.3
    var gap: Int = Int(Double(sortedArray.count) / shrinkFactor)
    
    while(gap >= 1) {
        var initialIndex = 0
        var gapIndex = gap
        while(gapIndex < array.count) {
            if sortedArray[initialIndex] > sortedArray[gapIndex] {
                let temp = sortedArray[initialIndex]
                sortedArray[initialIndex] = sortedArray[gapIndex]
                sortedArray[gapIndex] = temp
            }
            initialIndex += 1
            gapIndex += 1
        }
        
        gap = Int(Double(gap) / shrinkFactor)
    }
    
    return sortedArray
}

var array = [8, 2, 4, 10, 5, 6, 7, 1, 9, 3]

print("Unsorted Array: ")
printArray(array)

array = combSort(array)

print("Sorted Array: ")
printArray(array)

