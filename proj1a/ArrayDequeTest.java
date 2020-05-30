import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void test() {
        ArrayDeque<String> a = new ArrayDeque<>();

        boolean isNull = a.isEmpty();
        System.out.println("create, and the deque is null, " + isNull);

        a.addFirst("love");
        a.addLast("zeze");
        a.addFirst("I");
        a.addLast("c");
        a.addLast("d");
        a.addLast("e");
        a.addLast("f");
        a.addLast("g");
        a.addLast("h");
        a.addFirst("b");
        a.addFirst("a");

        boolean isNull2 = a.isEmpty();
        System.out.println("add, and the deque is null, " + isNull2);

        a.printDeque();
        System.out.println("size is " + a.size());
        System.out.println("love is " + a.get(1));

        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();

        a.addFirst("zeze");
        a.addFirst("love");
        a.addFirst("I");

        a.printDeque();

    }
}
