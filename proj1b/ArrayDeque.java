public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextfirst;
    private int nextlast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextfirst = 0;
        nextlast = 1;
        size = 0;
    }

    /**
     * 将双端队列中数的下一个数的位置映射到实际的数组中。
     * 例如，这一个数索引为items.length-1（即数组最后），则下一个数
     * 应该位于0位置.若索引还不到最后一位，则下一个数的位置
     * 就是下一个数的索引，正常+1即可。
     * <p>
     * 这个trick应该很常用于循环。每次将索引+1，一到某个阈值
     * 就从头开始。
     *
     * @param a
     * @return
     */
    private int addOne(int a) {
        return (a + 1) % items.length;
    }

    private int subOne(int a) {
        return (a - 1 + items.length) % items.length;
    }

    /**
     * resize the array.
     * 主要思想是，将原数组从first到end复制新数组的0到size中。
     * 则新数组的nextfirst为新数组的最后一个，新数组的nextlast为新数组的size索引。
     *
     * @param length
     */
    private void resize(int length) {
        T[] newitems = (T[]) new Object[length];
        int oldindex = addOne(nextfirst);
        for (int i = 0; i < size; i++) {
            newitems[i] = items[oldindex];
            oldindex = addOne(oldindex);
        }
        this.items = newitems;
        nextfirst = items.length - 1;
        nextlast = size;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextfirst] = item;
        nextfirst = subOne(nextfirst);
        size += 1;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextlast] = item;
        nextlast = addOne(nextlast);
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int i = addOne(nextfirst);
        for (int j = 0; j < size; j++) {
            System.out.print(items[i] + " ");
            i = addOne(i);
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T a = items[addOne(nextfirst)];
        items[addOne(nextfirst)] = null;
        nextfirst = addOne(nextfirst);
        size -= 1;
        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return a;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T a = items[subOne(nextlast)];
        items[subOne(nextlast)] = null;
        nextlast = subOne(nextlast);
        size -= 1;
        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return a;
    }

    /**
     * (start + index) % items.length
     *
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int start = addOne(nextfirst);
        return items[(start + index) % items.length];
    }
}
