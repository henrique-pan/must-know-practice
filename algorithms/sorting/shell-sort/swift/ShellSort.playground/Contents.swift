/*
 
 Shell Sort:
 Worst Case Performance: O(n^2)
 Best Case Performance: O(n)
 Average Performance: O(n^2)
 
 https://en.wikipedia.org/wiki/Shellsort
 https://www.youtube.com/watch?v=SHcPqUe2GZM
 */

import Foundation

func printArray(_ array: [Int]) {
    var result = ""
    for element in array {
        result += "\(element) "
    }
    print(result)
}

func shellSort(_ array: [Int]) -> [Int] {
    var sortedArray = NSMutableArray(array: array) as! [Int]
    
    var gap = Int(sortedArray.count / 2)
    
    while gap > 0 {
        var gapIndex = gap
        while gapIndex < sortedArray.count {
            var i = gapIndex - gap
            var j = gapIndex
            while i >= 0 && sortedArray[i] > sortedArray[j] {
                let temp = sortedArray[i]
                sortedArray[i] = sortedArray[j]
                sortedArray[j] = temp
                i -= gap
                j -= gap
            }
         gapIndex += 1
        }
        gap = Int(gap / 2)
    }
    
    return sortedArray
}

var array = [8, 2, 5, 3, 4, 9, 10, 7, 1, 6]

print("Unsorted Array: ")
printArray(array)

array = shellSort(array)

print("Sorted Array: ")
printArray(array)



