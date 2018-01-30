import java.util.*;

public class RemoveDups {

	public static void main(String[] args) {

		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.print();


        //removeDups(list);
        removeDupsWithoutHash(list);
        list.print();

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

        removeDupsWithoutHash(list);
        list.print();
	}

	private static void removeDups(SinglyLinkedList<Integer> list) {
		if(list.size() > 0) {
			HashSet<Integer> set = new HashSet<Integer>();

			Node<Integer> previus = null;
			Node<Integer> iterator = list.head;
			while(iterator != null) {
				if(set.contains(iterator.element)) {
					previus.nextNode = iterator.nextNode;
				} else {
					set.add(iterator.element);
					previus = iterator;
				}
				iterator = iterator.nextNode;
			}	
		}
	}

	private static void removeDupsWithoutHash(SinglyLinkedList<Integer> list) {
		if(list.size() > 0) {
			Node<Integer> iteratorMain = list.head;
			while(iteratorMain != null) {
				Node<Integer> iteratorInner = iteratorMain;
				while(iteratorInner.nextNode != null) {
					if(iteratorMain.element.equals(iteratorInner.nextNode.element)) {
						iteratorInner.nextNode = iteratorInner.nextNode.nextNode;
					} else {
						iteratorInner = iteratorInner.nextNode;
					}
				}	
				iteratorMain = iteratorMain.nextNode;
			}	
		}
	}

}









