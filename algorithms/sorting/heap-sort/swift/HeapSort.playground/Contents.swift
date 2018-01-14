/*
 Heap Sort:
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



func printArray(_ array: [Int]) {
    var result = ""
    for e in array {
        result += "\(e) "
    }
    print(result)
}

func heapfy(_ unsortedHeap: [Int], _ length: Int, _ rootIndex: Int) -> [Int] {
    var heap = NSMutableArray(array: unsortedHeap) as! [Int]
    
    var largestIndex = rootIndex
    let leftIndex = rootIndex * 2 + 1
    let rightIndex = rootIndex * 2 + 2
    
    if(leftIndex < length && heap[leftIndex] > heap[largestIndex]) {
        largestIndex = leftIndex
    }
    
    if(rightIndex < length && heap[rightIndex] > heap[largestIndex]) {
        largestIndex = rightIndex
    }
    
    if(largestIndex != rootIndex) {
        let temp = heap[largestIndex]
        heap[largestIndex] = heap[rootIndex]
        heap[rootIndex] = temp
        
        heap = heapfy(heap, length, largestIndex)
    }
    
    return heap
}

func heapSort(_ unsortedArray: [Int]) -> [Int] {
    var array = NSMutableArray(array: unsortedArray) as! [Int]
    
    let n = Int(array.count / 2) - 1
    for i in (0 ... n).reversed() {
        array = heapfy(array, array.count, i)
    }
    
    var currentIndex = array.count - 1
    while(currentIndex > 0) {
        let temp = array[0]
        array[0] = array[currentIndex]
        array[currentIndex] = temp
        
        array = heapfy(array, currentIndex, 0)
        currentIndex -= 1
    }
    
    return array
}



var array = [9, 7, 1, 3, 10, 6, 5, 4, 2, 8]

print("Unsorted Array: ")
printArray(array)

array = heapSort(array)

print("Sorted Array: ")
printArray(array)
