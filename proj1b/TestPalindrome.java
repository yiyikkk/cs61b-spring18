import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne cc = new OffByOne();

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
        String a = "abc";
        assertFalse(palindrome.isPalindrome(a));
        String b = "b";
        assertTrue(palindrome.isPalindrome(b));
        String c = "";
        assertTrue(palindrome.isPalindrome(c));
        String d = "dadad";
        assertTrue(palindrome.isPalindrome(d));

        String a1 = "flake";
        assertTrue(palindrome.isPalindrome(a1, cc));
        String b1 = "b";
        assertTrue(palindrome.isPalindrome(b1, cc));
        String c1 = "";
        assertTrue(palindrome.isPalindrome(c1, cc));
        String d1 = "dadad";
        assertFalse(palindrome.isPalindrome(d1, cc));
    }
}
