public class ArrayDeque<Item> implements Deque<Item>{

    public Item[] array ;
    private int nextFirst;
    private int nextLast;
    private int size;

    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(array,0,a,0,size);
        array = a;

        nextFirst = capacity - 1;
        nextLast = size;
    }

    public ArrayDeque() {
        size = 0;
        array = (Item[]) new Object[8];
        nextFirst = 0;
        nextLast = 0;
    }

    public void addFirst(Item item) {
        array[nextFirst] = item;
        if (this.nextFirst == 0) {
            nextFirst = size - 1;
        } else {
            nextFirst--;
        }
        size++;

        if (size == array.length) {
            resize(array.length * 2);
        }
    }
    public void addLast(Item item) {
        array[nextLast] = item;
        if (nextLast == size - 1) {
            nextLast = 0;
        } else {
            nextLast++;
        }
        size++;

        if (size == array.length) {
            resize(array.length * 2);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return  size;
    }

    public void printDeque() {
        for (int i = 0; i <= array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public Item removeFirst() {
        Item item = array[nextFirst + 1];
        if (nextFirst == size - 1) {
            nextFirst = 0;
        } else {
            nextFirst++;
        }
        size--;
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return item;
    }

    public Item removeLast() {
        Item item = array[nextLast - 1];
        if (nextLast == 0) {
            nextLast = size - 1;
        } else {
            nextLast--;
        }
        size--;
        if(size == array.length / 4) {
            resize(array.length / 2);
        }
        return item;
    }

    public Item get(int index) {
        return array[index];
    }
}
