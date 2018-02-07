class Node {

	int data;

	Node leftChild;
	Node rightChild;

	Node(int data) {
		this.data = data;
	}

	// Balanced O(log n)
	public void insert(int value) {
		if(value <= data) {
			if(leftChild == null) {
				leftChild = new Node(value);
			} else {
				leftChild.insert(value);
			}
		} else {
			if(rightChild == null) {
				rightChild = new Node(value);
			} else {
				rightChild.insert(value);
			}
		}
	}

	public boolean contains(int value) {
		if(value == data) {
			return true;
		} else if(value < data) {
			if(leftChild == null) {
				return false;
			}
			leftChild.contains(value);
		} else {
			if(rightChild == null) {
				return false;
			}
			rightChild.contains(value);
		}
		return false;
	}

	public void printInOrder() {
		if(leftChild != null) {
			leftChild.printInOrder();
		}

		System.out.println(data);

		if(rightChild != null) {
			rightChild.printInOrder();
		}
	}

	public void printPreOrder() {
		System.out.println(data);

		if(leftChild != null) {
			leftChild.printInOrder();
		}
		
		if(rightChild != null) {
			rightChild.printInOrder();
		}
	}

	public void printPostOrder() {
		if(leftChild != null) {
			leftChild.printInOrder();
		}
		
		if(rightChild != null) {
			rightChild.printInOrder();
		}

		System.out.println(data);
	}


	public static void main(String args[]) {
		Node root = new Node(10);

		root.insert(1);
		root.insert(5);
		root.insert(2);
		root.insert(6);
		root.insert(7);
		root.insert(12);
		root.insert(8);
		root.insert(9);
		root.insert(3);

		root.printInOrder();
		root.printPreOrder();
		root.printPostOrder();

	}

}