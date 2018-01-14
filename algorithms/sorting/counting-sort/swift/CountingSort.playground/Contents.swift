/*
 
 Counting Sort:
 Worst Case Performance:
 Best Case Performance:
 Average Performance:
 
 */

import Foundation

var array = [8, 3, 1, 10, 5, 9, 4, 7, 6, 2]

func printArray(_ array: [Int]) {
    var result = ""
    for e in array {
        result += "\(e) "
    }
    print(result)
}

func countingSort(_ unsortedArray: [Int]) -> [Int] {
    var array = NSMutableArray(array: unsortedArray) as! [Int]
    
    var highestElement = array[0]
    for i in 0 ..< array.count {
        if array[i] > highestElement {
            highestElement = array[i]
        }
    }
    
    highestElement += 1
    var counter = [Int](repeating: 0, count: highestElement)
    
    for i in 0 ..< array.count {
        counter[array[i]] += 1
    }
    
    var index = 0
    for i in 0 ..< highestElement {
        for j in 0 ..< counter[i] {
            array[index] = i
            index += 1
        }
    }
    
    return array
}


print("Unsorted Array: ")
printArray(array)

array = countingSort(array)

print("Sorted Array: ")
printArray(array)
