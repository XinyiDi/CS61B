package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing L_nr = new AListNoResizing();
        BuggyAList L_buggy = new BuggyAList();

        L_nr.addLast(4);
        L_buggy.addLast(4);
        L_nr.addLast(5);
        L_buggy.addLast(5);
        L_nr.addLast(6);
        L_buggy.addLast(6);

        assertEquals(L_nr.size(), L_buggy.size());
        assertEquals(L_nr.removeLast(), L_buggy.removeLast());
        assertEquals(L_nr.removeLast(), L_buggy.removeLast());
        assertEquals(L_nr.removeLast(), L_buggy.removeLast());

    }
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeB = B.size();
                //System.out.println("size of correct: " + size);
                //System.out.println("size of buggy: " + sizeB);
                assertEquals(size, sizeB);

            } else if (operationNumber == 2){
                if ((L.size() == 0) || (B.size() ==0)){
                    continue;
                }
                int last = L.getLast();
                int lastB = B.getLast();
                //System.out.println("getLast() of correct: " + last );
                //System.out.println("getLast() of buggy: " + lastB );
                assertEquals(last, lastB);
            } else if (operationNumber == 3){
                if ((L.size() == 0) || (B.size() ==0)){
                    continue;
                }
                int last = L.removeLast();
                int lastB = B.removeLast();
                //System.out.println("removeLast() of correction: " + last);
                //System.out.println("removeLast() of buggy: " + lastB);
                assertEquals(last, lastB);
            }
            }
        }
    }



