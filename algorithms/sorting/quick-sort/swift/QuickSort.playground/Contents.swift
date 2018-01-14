import Foundation

func printArray(_ array: [Int]) {
    var result = ""
    for e in array {
        result += "\(e) "
    }
    print(result)
}

func quickSort(_ unsortedArray: [Int], _ initialIndex: Int, _ endIndex: Int) -> [Int] {
    if initialIndex >= endIndex {
        return unsortedArray
    } else {
        var array = NSMutableArray(array: unsortedArray) as! [Int]
        
        let pivot = endIndex
        var wallIndex = initialIndex
        var currentIndex = initialIndex
        
        while(currentIndex < endIndex) {
            if(array[currentIndex] < array[pivot]) {
                if(currentIndex != wallIndex) {
                    let temp = array[wallIndex]
                    array[wallIndex] = array[currentIndex]
                    array[currentIndex] = temp
                }
                wallIndex += 1
            }
            currentIndex += 1
        }
        
        let temp = array[pivot]
        array[pivot] = array[wallIndex]
        array[wallIndex] = temp
        
        let leftArray = quickSort(array, initialIndex, (wallIndex - 1))
        let sortedArray = quickSort(leftArray, (wallIndex + 1), endIndex)
        
        return sortedArray
    }
}


var array = [8, 4, 2, 1, 10, 9, 8, 6, 5, 3]
print("Unsorted Array: ")
printArray(array)

array = quickSort(array, 0, array.count - 1)

print("Sorted Array: ")
printArray(array)




