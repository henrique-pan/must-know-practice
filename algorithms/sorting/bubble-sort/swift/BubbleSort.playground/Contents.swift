import Foundation

func bubbleSort(_ array: [Int]) -> [Int]{
    var s = array.count
    var sortedArray = NSMutableArray(array: array) as! [Int]
    
    while(s > 1) {
        for i in 0 ..< (s - 1) {
            if sortedArray[i] > sortedArray[i + 1] {
                sortedArray.swapAt(i, i + 1)
            }
        }
        s -= 1
    }
    
    return sortedArray
}

var array = [5,3,4,6,8,2,9,1,7,10,11]

print("Unsorted array: ")
print(array)

array = bubbleSort(array)

print("Sorted array: ")
print(array)



