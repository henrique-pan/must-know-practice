/*
 
 Radix Sort:
    Worst Case Performance:
    Best Case Performance:
    Average Performance:
 
    https://www.geeksforgeeks.org/heap-sort/
    https://en.wikipedia.org/wiki/Heapsort
    https://www.youtube.com/watch?v=MtQL_ll5KhQ
    https://www.youtube.com/watch?v=t0Cq6tVNRBA
    https://www.youtube.com/watch?v=QdRL3XLyiVc
 */
import Foundation

func countingSort(_ unsortedArray: [Int], _ exp: Int) -> [Int] {
    var array = NSMutableArray(array: unsortedArray) as! [Int]
    
    var output = [Int](repeating: 0, count: array.count)
    var counter = [Int](repeating: 0, count: 10)
    
    for e in array {
        let index = (e / exp) % 10
        counter[index] += 1
    }
    
    for i in 1 ..< counter.count {
        counter[i] += counter[i - 1]
    }
    
    for i in (0 ..< array.count).reversed() {
        let index = (array[i] / exp) % 10
        output[counter[index] - 1] = array[i]
        counter[index] -= 1
    }
    
    for i in 0 ..< array.count {
        array[i] = output[i]
    }
    
    return array
}

func radixSort(_ unsortedArray: [Int]) -> [Int] {
    var array = NSMutableArray(array: unsortedArray) as! [Int]
    
    var max = array[0]
    for e in array {
        if(e > max) {
            max = e
        }
    }
    
    var exp = 1
    while((max / exp) > 0) {
        array = countingSort(array, exp)
        exp *= 10
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


var array = [5, 19, 67, 100, 3, 81, 892]

print("Unsorted Array: ")
printArray(array)

array = radixSort(array)

print("Sorted Array: ")
printArray(array)
