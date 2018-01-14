import Foundation

func gnomeSort(_ unsortedArray: [Int]) -> [Int] {
    var array = NSMutableArray(array: unsortedArray) as! [Int]
    
    var currentIndex = 1
    while(currentIndex < array.count) {
        var gnomeIndex = currentIndex
        while(gnomeIndex > 0 && array[gnomeIndex] < array[gnomeIndex - 1]) {
            let temp = array[gnomeIndex]
            array[gnomeIndex] = array[gnomeIndex - 1]
            array[gnomeIndex - 1] = temp
            
            gnomeIndex -= 1
        }
        currentIndex += 1
    }
    
    return array
}

func printArray(_ array: [Int]) {
    var result = ""
    for e in array {
        result += "\(e) "
    }
    print(result)
}

var array = [8, 3, 5, 1, 10, 9, 4, 2, 7, 6]

print("Unsorted Array: ")
printArray(array)

array = gnomeSort(array)

print("Sorted Array: ")
printArray(array)


