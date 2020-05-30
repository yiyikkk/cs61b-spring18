public class LinkedListDeque<T> {
    public class ItemNode {
        public T item;
        public ItemNode pre;
        public ItemNode next;

        public ItemNode(T item, ItemNode pre, ItemNode next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    private int size;
    private ItemNode sentinel;

    //这里可以写sentinel = new ItemNode(null,sentinel,sentinel)吗？好像不行，因为代码是从右往左执行的;
    public LinkedListDeque() {
        sentinel = new ItemNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentinel = new ItemNode(null, null, null);
        sentinel.next = new ItemNode(item, sentinel, null);
        sentinel.pre = sentinel.next;
        size = 1;
    }

    public void addFirst(T item) {
        ItemNode a = new ItemNode(item, sentinel, sentinel.next);
        sentinel.next.pre = a;
        sentinel.next = a;
        size += 1;
    }

    public void addLast(T item) {
        ItemNode a = new ItemNode(item, sentinel.pre, sentinel);
        sentinel.pre.next = a;
        sentinel.pre = a;
        size += 1;
    }

    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ItemNode p = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    public T removeFirst() {
        if (sentinel.next == sentinel) return null;
        T a = sentinel.next.item;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        return a;
    }

    public T removeLast() {
        if (sentinel.next == sentinel) return null;
        T a = sentinel.pre.item;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        return a;
    }

    public T get(int index) {
        ItemNode p = sentinel.next;
        if (index > size - 1) return null;
        for (int i = 0; i < size; i++, p = p.next) {
            if (i == index) {
                return p.item;
            }
        }
        return null;
    }

    public T getRecursive(int index) {
        if (index > size - 1) return null;
        return getR(sentinel.next, index);
    }

    private T getR(ItemNode l, int i) {
        if (i == 0) {
            return l.item;
        }
        return getR(l.next, i - 1);
    }
}
