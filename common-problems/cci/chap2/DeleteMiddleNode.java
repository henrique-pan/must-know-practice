import java.util.*;

public class DeleteMiddleNode {

	public static void main(String[] args) {

		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.add(3);
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(9);
        list.add(8);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(0);
        list.print();

        Node<Integer> node = kthToLast(list.head, 5);

        boolean result = deleteMiddle(node);

        System.out.println("RESULT: " + result);
        list.print();
	}

	private static boolean deleteMiddle(Node<Integer> node) {
		// Check if it is the first or the last
		if(node == null || node.nextNode == null) {
			return false;
		}

		Node<Integer> nextNode = node.nextNode;
		node.element = nextNode.element;
		node.nextNode = nextNode.nextNode;

		return true;
	}

	private static Node<Integer> kthToLast(Node<Integer> head, int k) {
		Node<Integer> p1 = head;
		Node<Integer> p2 = head;		

		// Count k elements
		for(int i = 0; i < k; i++) {
			if(p1 == null) {
				return null;
			}
			p1 = p1.nextNode;
		}

		// P1 until Tail
		// P2 until kth element
		while(p1 != null) {	
			p1 = p1.nextNode;
			p2 = p2.nextNode;
		}

		return p2;
	}

}









