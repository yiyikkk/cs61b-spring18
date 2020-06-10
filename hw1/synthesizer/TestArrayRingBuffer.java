package synthesizer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.isEmpty();       //                       (returns true)
        arb.enqueue(9.3);    // 9.3
        arb.enqueue(15.1);   // 9.3  15.1
        arb.enqueue(31.2);   // 9.3  15.1  31.2
        arb.isFull();        // 9.3  15.1  31.2       (returns false)
        arb.enqueue(-3.1);   // 9.3  15.1  31.2  -3.1
        arb.isFull();        // 9.3  15.1  31.2  -3.1 (returns true)
        //arb.dequeue();       // 15.1 31.2  -3.1       (returns 9.3)
        arb.peek();          // 15.1 31.2  -3.1       (returns 15.1)
        for (Object a : arb) {
            System.out.print(a + " ");
        }
    }

    /**
     * Calls tests for ArrayRingBuffer.
     */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
