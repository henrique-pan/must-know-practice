import java.util.*;

public class LoopDetection {

	public static void main(String[] args) {

		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.add(3);
        list.add(5);
        list.add(2);
        list.add(1);
        list.print();

        Node<Integer> startPoint = list.tail;
        startPoint.nextNode = list.head.nextNode;

        Node<Integer> node = findBegining(list.head);
        System.out.println("Cycle Start: " + node.element);
	}

	private static Node<Integer> findBegining(Node<Integer> head) {
		Node<Integer> slow = head;
		Node<Integer> fast = head;

		while(fast != null && fast.nextNode != null) {
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
			if(slow == fast) {
				break;
			}
		}

		if(fast == null || fast.nextNode == null) {
			return null;
		}

		slow = head;
		while(slow != fast) {
			slow = slow.nextNode;
			fast = fast.nextNode;
		}

		return fast;
	}

}









