import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        OffByOne cc = new OffByOne();
        String a = "flake";
        assertTrue(palindrome.isPalindrome(a, cc));

        String b = "bb";
        assertFalse(palindrome.isPalindrome(b, cc));

        String c = "";
        assertTrue(palindrome.isPalindrome(c, cc));

        String d = "dadad";
        assertFalse(palindrome.isPalindrome(d, cc));
    }
}
