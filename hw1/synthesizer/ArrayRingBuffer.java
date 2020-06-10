package synthesizer;

import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = 0;
        last = 0;
        rb = (T[]) new Object[capacity];
        this.capacity = capacity;
        fillCount = 0;
    }

    private int addOne(int index) {
        return (index + 1 + capacity) % capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        last = addOne(last);
        fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T a = rb[first];
        rb[first] = null;
        first = addOne(first);
        fillCount -= 1;
        return a;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (!isEmpty()) {
            return rb[first];
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        private int p;
        private int begin;

        private Iter() {
            p = first;
            begin = 0;
        }

        @Override
        public boolean hasNext() {
            return (rb[p] != null) && !(p == first && begin == 1);
            //true : p=first and begin=0 or p != first; false : p = first and begin=1
        }

        @Override
        public T next() {
            T a = rb[p];
            p = addOne(p);
            begin = 1;
            return a;
        }
    }
}
