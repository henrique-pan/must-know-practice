import java.util.*;

public class Palindrome {

	public static void main(String[] args) {

		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.add(3);
        list.add(5);
        list.add(8);
        list.add(5);
        list.add(10);
        list.add(2);
        list.add(1);
        list.print();

        boolean result = isPalindrome(list.head);
        System.out.println(result);

        list = new SinglyLinkedList<>();

        list.add(3);
        list.add(5);
        list.add(8);
        list.add(5);
        list.add(3);
        list.print();

        result = isPalindrome(list.head);
        System.out.println(result);
	}

	private static boolean isPalindrome(Node<Integer> head) {
		Node<Integer> reversed = reverseAndClone(head);
		return isEqual(head, reversed);
	}

	private static Node<Integer> reverseAndClone(Node<Integer> node) {
		Node<Integer> head = null;
		while(node != null) {
			Node<Integer> n = new Node<Integer>(node.element);
			n.nextNode = head;
			head = n;
			node = node.nextNode;
		}
		return head;
	}

	private static boolean isEqual(Node<Integer> nodeA, Node<Integer> nodeB) {
		while(nodeA != null && nodeB != null) {
			if(nodeA.element != nodeB.element) {
				return false;
			}
			nodeA = nodeA.nextNode;
			nodeB = nodeB.nextNode;
		}
		
		return nodeA == null && nodeB == null;
	}

}