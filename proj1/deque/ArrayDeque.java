package deque;

public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty array deque. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }

    public void addFirst(T item){
        if (size == items.length){
            resize(size * 2);
        }

        items[nextFirst] = item;
        size += 1;
        if (nextFirst - 1 < 0){
            nextFirst = items.length - 1;
        } else {
            nextFirst = nextFirst - 1;
        }
    }


    public void addLast(T item){
        if (size == items.length) {
            resize(size * 2);
        }
            items[nextLast] = item;
            size += 1;
            if (nextLast + 1 > items.length - 1) {
                nextLast = 0;
            }  else {
                nextLast = nextLast + 1;
            }
        }




    public int size(){
        return size;
    }



    public void printDeque(){
        if (nextFirst == items.length - 1){
            for (int i = 0; i < nextLast; i += 1){
                System.out.print(items[i]);
            }
        } else if(nextFirst < nextLast){
            for (int i = nextFirst + 1; i < nextLast; i += 1){
                System.out.print(items[i]);}
        } else if(nextFirst >= nextLast){
                int i = nextFirst + 1;
                while (i != nextLast){
                    System.out.print(items[i]);
                    if (i == items.length - 1){
                        i = 0;
                    } else {
                        i += 1;
                    }
                }
            }
        }
    public T removeFirst(){
        T item;
        if (size == 0){
            return null;
        }
        size -= 1;
        if (nextFirst == items.length - 1){
            item = items[0];
            items[0] = null;
            nextFirst = 0;
        } else {
            item = items[nextFirst + 1];
            items[nextFirst + 1] = null;
            nextFirst = nextFirst + 1;
        }
        return item;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast(){
        T item;
        if (size == 0){
            return null;
        }
        size -= 1;
        if (nextLast == 0){
            item = items[items.length - 1];
            items[items.length - 1] = null;
            nextLast = items.length - 1;
        } else {
            item = items[nextLast - 1];
            items[nextLast - 1] = null;
            nextLast = nextLast - 1;
        }
        return item;
    }

    //这个get method 真的很牛。。谢谢gpt
    public T get(int index){
        if (index < 0 || index >= size) {
            return null; // or throw an exception
        }
        int realIndex = (nextFirst + 1 + index) % items.length;
        return items[realIndex];
    }

    /** Resizes the underlying array to the target capacity. */
    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];

        // Scenario 1
        if (nextLast == 0){
            System.arraycopy(items, 0, a, 0, size);
            nextLast = size;
            nextFirst = items.length-1;
        } else {//Scenario 2
            //int sizefromfirsttoend = size-1-nextFirst;
            System.arraycopy(items,0, a, 0, nextLast);
            // wrong length
            System.arraycopy(items,nextFirst + 1, a, capacity-(size-nextFirst)+1, size-nextFirst-1);
            //nextLast stay unchanged;
            nextFirst = capacity-(size-nextFirst);
        }
        items = a;
    }




}