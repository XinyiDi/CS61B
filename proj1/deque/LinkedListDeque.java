package deque;

public class LinkedListDeque<T> implements Deque<T> {

    /* Create node class */
    private class StuffNode {
        public T item;
        public StuffNode next;
        public StuffNode prev;

        public StuffNode(T i, StuffNode m, StuffNode n) {
            item = i;
            prev = m;
            next = n;
        }
    }

    /* Create LinkedLiseDeque class variables*/
    private StuffNode sentinel;
    private int size;

    /** Creates an empty list. */
    public LinkedListDeque(){
        //LochNess a = (LochNess) new Object(); /* assign item value to a for sentinel) */
        sentinel = new StuffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }


    /** Adds x to the front of the list. */
    public void addFirst(T x) {
        sentinel.next.prev = new StuffNode(x, sentinel, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size += 1;
    }


    /** Adds an item to the end of the list. */
    public void addLast(T x) {
        size += 1;
        StuffNode newNode = new StuffNode(x, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
    }


    public int size() {
        return size;
    }

    public void printDeque(){
        StuffNode node = sentinel.next;
        while (node != sentinel){
            System.out.print(node.item + " ");
            node = node.next;
        }
        System.out.println();
    }

    public T removeFirst(){
        if (size == 0){
            return null;
        } else {
            T item = sentinel.next.item;
            //String itemAsString = item.toString();
            //int intValue = Integer.parseInt(itemAsString);
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return item;
        }
    }

    public T removeLast(){
        if (size == 0){
            return null;
        } else {
            T item = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return item;
        }
    }

    public T get(int index){
        if (index < 0 || index >= size){
            return null;
        }
        StuffNode node = sentinel.next;
        for (int i =0 ; i < index; i += 1){
            node = node.next;
        }
        return node.item;
    }

    public T getRecursiveHelper(StuffNode node, int index){
        if (index == 0){
            return node.item;
        }
        return getRecursiveHelper(node.next, index - 1);
    }
    public T getRecursive(int index) {
        if (index < 0 || index >= size){
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }



}
