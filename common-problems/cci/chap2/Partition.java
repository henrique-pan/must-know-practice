import java.util.*;

public class Partition {

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

        partitionDuplication(list.head, 5);
        list.print();

        partitionHeadTail(list.head, 1);
        list.print();
	}

	private static Node<Integer> partitionDuplication(Node<Integer> node, int x) {
		Node<Integer> beforeHead = null;
		Node<Integer> beforeTail = null;
		Node<Integer> afterHead = null;
		Node<Integer> afterTail = null;

		while(node != null) {
			Node<Integer> next = node.nextNode;
			node.nextNode = null;
			if(node.element < x) {
				if(beforeHead == null) {
					beforeHead = node;
					beforeTail = beforeHead;
				} else {
					beforeTail.nextNode = node;
					beforeTail = node;
				}
			} else {
				if(afterHead == null) {
					afterHead = node;
					afterTail = afterHead;
				} else {
					afterTail.nextNode = node;
					afterTail = node;
				}
			}
			node = next;
		}

		if(beforeHead == null) {
			return afterHead;
		}

		beforeTail.nextNode = afterHead;
		return beforeHead;
	}

	private static Node<Integer> partitionHeadTail(Node<Integer> node, int x) {
		Node<Integer> head = node;
		Node<Integer> tail = node;		

		while(node != null) {
			Node<Integer> next = node.nextNode;
			if(node.element < x) {
				node.nextNode = head;
				head = node;
			} else {
				tail.nextNode = node;
				tail = node;
			}
			node = next;
		}
		tail.nextNode = null;

		return head;
	}

}