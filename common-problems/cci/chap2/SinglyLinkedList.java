import java.util.*;

class SinglyLinkedList<E> {
    
    private int size;
    Node<E> head;
    Node<E> tail;

    public SinglyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public void add(E element) {
        if(head == null) {
            head = new Node(element);
            tail = head;
        } else {
            Node iteratorNode = head;
            while(iteratorNode.nextNode != null) {
                iteratorNode = iteratorNode.nextNode;
            }
            iteratorNode.nextNode = new Node(element);
            tail = iteratorNode.nextNode;
        }
        size++;
    }

    public E getFirst() {
        if(size > 0) {
            return head.element;
        }
        return null;
    }

    public E getLast() {
        if(size > 0) {
            return tail.element;
        }
        return null;
    }

    public void set(E element, int index) {
        if(index >= 0 && index < size) {
            int counter = 0;
            Node iteratorNode = head;
            do {
                if(index == counter) {
                    iteratorNode.element = element;
                    return;
                } else {
                    iteratorNode = iteratorNode.nextNode;  
                    counter++;  
                } 
            } while(iteratorNode != null);
        }
    }

    public void remove(int index) {
        if(index >= 0 && index < size) {
            int counter = 0;
            Node iteratorNode = head;
            do {
                if(index == 0 && counter == 0) {
                    head = iteratorNode.nextNode;
                    size--;
                    return;
                } else if(index == (counter + 1)) {
                    iteratorNode.nextNode = iteratorNode.nextNode.nextNode;
                    if(index == (size - 1)) {
                        tail = iteratorNode;
                    }
                    size--;
                    return;
                } else {
                    iteratorNode = iteratorNode.nextNode;  
                    counter++;  
                } 
            } while(iteratorNode != null);
        }
    }

    public int size() {
        return size;
    }

    public void print() {
        if(size > 0) {
            int counter = 0;
            Node iteratorNode = head;
            do {
                System.out.println(counter + " : " + iteratorNode.element);
                iteratorNode = iteratorNode.nextNode;
                counter++;  
            } while(iteratorNode != null); 
            System.out.println("");
        }        
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        System.out.println("First Element: " + list.getFirst());
        System.out.println("Last Element: " + list.getLast());

        list.remove(3);
        list.print();
        System.out.println("First Element: " + list.getFirst());
        System.out.println("Last Element: " + list.getLast());

        list.remove(0);
        list.print();
        System.out.println("First Element: " + list.getFirst());
        System.out.println("Last Element: " + list.getLast());

        list.remove(2);
        list.print();
        System.out.println("First Element: " + list.getFirst());
        System.out.println("Last Element: " + list.getLast());

        list.add(1);
        list.add(4);
        list.add(5);
        list.print();
        System.out.println("First Element: " + list.getFirst());
        System.out.println("Last Element: " + list.getLast());

        list.set(0, 0);
        list.print();
        System.out.println("First Element: " + list.getFirst());
        System.out.println("Last Element: " + list.getLast());

        list.set(6, 3);
        list.print();
        System.out.println("First Element: " + list.getFirst());
        System.out.println("Last Element: " + list.getLast());

    }

}

class Node<E> {

        E element;
        Node nextNode;

        public Node(E element) {
            nextNode = null;
            this.element = element;
        }

    }