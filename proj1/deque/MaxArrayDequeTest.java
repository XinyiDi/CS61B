package deque;


import org.junit.Test;
import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {
    public static class intComparator<T> implements Comparator<T> {
        @Override
        public int compare(T t1, T t2) {
            Integer i1 = (Integer) t1;
            Integer i2 = (Integer) t2;
            return i1 - i2;
        }
    }
    public static class stringComparator<T> implements Comparator<T> {
        @Override
        public int compare(T t1, T t2) {
            String s1 = (String) t1;
            String s2 = (String) t2;
            return s1.length() - s2.length();
        }
    }

    public static class stringComparatorInitial<T> implements Comparator<T> {
        @Override
        public int compare(T t1, T t2) {
            String si1 = (String) t1;
            String si2 = (String) t2;
            if (si1.compareTo(si2) < 0 || si1.compareTo(si2) == 0){
                return 1;
            } else {
                return -1;
            }
        }
    }
    @Test
    /** Check max array deque by using integer comparator defined by myself*/
    public void intComparatorTest (){

        // instantiate the int comparator of type Integer
        intComparator<Integer> myComparator = new intComparator<Integer>();

        // create a new MaxArrayDeque of type Integer
        MaxArrayDeque<Integer> mad1 = new MaxArrayDeque<Integer>(myComparator);

        // add elements to the max array deque
        mad1.addFirst(3);
        mad1.addFirst(4);
        mad1.addFirst(5);
        mad1.addFirst(2);

        int maxInt = mad1.max();

        String errorMsg = "  The max string should be .\n";
        errorMsg += "  max() returned " + maxInt + "\n";
        assertEquals(errorMsg, 5, maxInt);

    }
    @Test
    /** Check max() and also max (Comparator<T>) method by using string comparator defined by myself*/
    public void stringComparatorTest (){

        // instantiate the string comparator of type Integer
        stringComparator<String> myComparator = new stringComparator<>();
        // instantiate the string comparator of type Integer
        stringComparatorInitial<String> addedComparator = new stringComparatorInitial<>();

        // create a new MaxArrayDeque of type Integer
        MaxArrayDeque<String> mad1 = new MaxArrayDeque<>(myComparator);

        // add elements to the max array deque
        mad1.addFirst("potato");
        mad1.addFirst("moonology");
        mad1.addFirst("auma");
        mad1.addFirst("imperatrice");

        String maxString = mad1.max();

        String errorMsg = "  The max value should be imperatrice.\n";
        errorMsg += "  max() returned " + maxString + "\n";
        assertEquals(errorMsg, "imperatrice", maxString);

        String maxString2 = mad1.max(addedComparator);

        String errorMsg2 = "  The max value should be auma.\n";
        errorMsg2 += "  max() returned " + maxString2 + "\n";
        assertEquals(errorMsg2, "auma", maxString2);

    }

}
