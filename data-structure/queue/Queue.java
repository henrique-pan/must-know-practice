class Queue<E> {

    private class Node<E> {

        E element;
        Node<E> nextNode;

        public Node(E element) {
            this.element = element;
            nextNode = null;
        }

    }

    private int size;

    private Node<E> head;
    private Node<E> tail;

    public Queue() {
        size = 0;
        head = null;
        tail = null;
    }

    public void add(E element) {
        Node<E> node = new Node(element);

        if(size == 0) {
            tail = node;
            head = tail;
        } else {
            tail.nextNode = node;
            tail = node;
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
            size--;
            node.nextNode = null;
            return node.element;
        }
        return null;
    }


    public void print() {
        if(size > 0) {
            System.out.println("Size: " + size + "\n");
            Node<E> iterator = head;
            for(int i = 0; i < size; i++) {
                System.out.println(i + " : " + iterator.element);
                iterator = iterator.nextNode;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.print();

        System.out.println("Peek: " + queue.peek());
        System.out.println("Pop: " + queue.pop());

        queue.print();
    }

}