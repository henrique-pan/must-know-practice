import Foundation

func selectionSort(_ array: [Int]) -> [Int] {
    var sortedArray = NSMutableArray(array: array) as! [Int]
    
    var x = 0
    while(x < sortedArray.count) {
        var smallestElementIndex = x
        var smallestValue = sortedArray[x]
        for i in (x + 1)..<sortedArray.count {
            if sortedArray[i] < smallestValue {
                smallestElementIndex = i
                smallestValue = sortedArray[i]
            }
        }
        let temp = sortedArray[x]
        sortedArray[x] = sortedArray[smallestElementIndex]
        sortedArray[smallestElementIndex] = temp
        
        x += 1
    }
    return sortedArray
}

func printArray(_ array: [Int]) {
    for e in array {
        print("\(e) ")
    }
    print("\n")
}

var array = [1, 5, 3, 10, 9, 7, 6, 2]

print("Unsorted Array: ")
printArray(array)

array = selectionSort(array)

print("Sorted Array: ")
printArray(array)



