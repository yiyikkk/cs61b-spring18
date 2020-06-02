import static org.junit.Assert.*;
import org.junit.Test;


public class TestArrayDequeGold {
    ArrayDequeSolution<String> action;

    private String message() {
        String m = "\n";
        if (action.size() < 3) {
            for (String s : action) {
                m = m.concat(s + "\n");
            }
        } else {
            for (int j = 3; j >= 1; j--) {
                m = m.concat(action.get(action.size() - j) + "\n");
            }
        }
        return m;
    }

    @Test
    public void test1() {
        ArrayDequeSolution<Integer> correct = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        action = new ArrayDequeSolution<>();

        for (int i = 0; i < 50; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.25) {
                student.addLast(i);
                correct.addLast(i);
                action.addLast("addLast(" + i + ")");
            } else if (numberBetweenZeroAndOne >= 0.25 && numberBetweenZeroAndOne < 0.5) {
                student.addFirst(i);
                correct.addFirst(i);
                action.addLast("addFirst(" + i + ")");
            } else if (numberBetweenZeroAndOne >= 0.5 && numberBetweenZeroAndOne < 0.75) {
                assertEquals(message(), correct.size(), student.size());
                if (correct.size() != 0) {
                    action.addLast("removeFirst()");
                    assertEquals(message(), correct.removeFirst(), student.removeFirst());
                }
            } else {
                assertEquals(message(), correct.size(), student.size());
                if (correct.size() != 0) {
                    action.addLast("removeLast()");
                    assertEquals(message(), correct.removeLast(), student.removeLast());
                }
            }
        }
    }

    @Test
    public void test2() {
        ArrayDequeSolution<Integer> correct = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        action = new ArrayDequeSolution<>();

        student.addFirst(1);
        correct.addFirst(2);
        action.addFirst("addFirst(" + 2 + ")");

        assertEquals(message(), correct.size(), student.size());
        if (correct.size() != 0) {
            action.addLast("removeLast()");
            assertEquals(message(), correct.removeLast(), student.removeLast());
        }
    }
}
