import java.util.*;

class Stack<E> {
    
    private class Node<E> {

        E element;
        Node<E> nextNode;

        public Node(E element) {
            this.element = element;
            nextNode = null;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

    }

    int size;
    Node<E> head;

    public Stack() {
        size = 0;
        head = null;
    }

    public void push(E element) {
        Node<E> node = new Node<E>(element);

        if(head == null) {
            head = node;
        } else {
            node.nextNode = head;
            head = node;
        }
        size++;
    }

    public E peek() {
        if(size > 0) {
            return head.element;
        }
        return null; 
    }

    public E pop() {
        if(size > 0) {
            Node<E> node = head;
            head = head.nextNode;

            node.nextNode = null;

            size--;

            return node.element;
        }
        return null; 
    }

    public void print() {
        if(size > 0) {
            Node<E> iterator = head;
            System.out.println("Size: " + size + "\n");
            for(int i = 0; i < size; i++) {
                System.out.println(i + " : " + iterator.element);
                iterator = iterator.nextNode;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        stack.print();

        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.print();

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());

        stack.print();
    }

}