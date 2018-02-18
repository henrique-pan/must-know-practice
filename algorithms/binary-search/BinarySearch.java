public class BinarySearch {

	public static void main(String[] args) {
		int[] array = new int[100];

		for(int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}

		if(binarySearchIterative(array, 39)){
			System.out.println("binarySearchIterative worked well!");
		} else {
			System.out.println("It's better to review the binarySearchIterative!");
		}

		if(binarySearchRecursive(array, 39)){
			System.out.println("binarySearchRecursive worked well!");
		} else {
			System.out.println("It's better to review the binarySearchRecursive!");
		}
	}


	public static boolean binarySearchIterative(int[] array, int x) {
		int left = 0;
		int right = array.length - 1;

		while(left <= right) {
			int middle = left + ((right - left)/2);

			if(array[middle] == x) {
				return true;
			} else if(x < array[middle]) {
				right =  middle - 1;
			} else {
				left = middle + 1;
			}
		}

		return false;
	}

	public static boolean binarySearchRecursive(int[] array, int x, int left, int right) {
		if(left > right) {
			return false;
		}

		int middle = left + ((right - left) / 2);
		if(array[middle] == x) {
			return true;
		} else if(x < array[middle]) {
			return binarySearchRecursive(array, x, left, middle - 1);
		} else {
			return binarySearchRecursive(array, x, middle + 1, right);
		}
	}

	public static boolean binarySearchRecursive(int[] array, int x) {
		return binarySearchRecursive(array, x, 0, array.length - 1);
	}

}