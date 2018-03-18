public class LinkedListDeque<T> {

    public class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(this.sentinel,null,this.sentinel);    //Circular Sentinel topology
    }

    public void addFirst(T item) {
        Node newFirstNode;
        if (this.isEmpty()) {
            newFirstNode = new Node(this.sentinel, item, this.sentinel);
            this.sentinel.prev = newFirstNode;
        } else {
            Node oldFirstNode = this.sentinel.next;
            newFirstNode = new Node(this.sentinel, item, oldFirstNode);
        }
        this.sentinel.next = newFirstNode;
        this.size++;
    }

   public void addLast(T item) {
        Node newLastNode;
        if (this.isEmpty()) {
            newLastNode = new Node(this.sentinel, item, this.sentinel);
            this.sentinel.next = newLastNode;
        } else {
            Node oldLastNode = this.sentinel.prev;
            newLastNode = new Node(oldLastNode, item, this.sentinel);
            newLastNode.next = newLastNode;
        }
        this.sentinel.prev = newLastNode;
        this.size++;
    }

    public boolean isEmpty() {
        while(this.size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = this.sentinel.next;
        while(p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            Node firstNode = sentinel.next;
            T firstReturn = firstNode.item;
            sentinel.next = firstNode.next;
            size--;
            return firstReturn;
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            Node lastNode = sentinel.prev;
            T lastReturn = lastNode.item;
            sentinel.prev = lastNode.prev;
            size--;
            return lastReturn;
        }
    }

    public T get(int index) {
        if (index > this.size) {
            return null;
        } else {
            Node p = sentinel.next;
            for (int count = 0; count < index; count++) {
                p = p.next;
            }
            return p.item;
        }
    }

    private T recursiveHelper(Node p,int index) {
        if (index == 0) {
            return p.item;
        }
        return recursiveHelper(p.next,index - 1);
    }

    public T getRecursive(int index) {
        if(index > size) {
            return null;
        } else {
            return recursiveHelper(sentinel.next,index);
        }
    }


}