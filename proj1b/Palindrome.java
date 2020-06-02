public class Palindrome {
    /**
     * store characters of a string into a deque.
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    public boolean isPalindrome1(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }

    public boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }
        Deque<Character> a = wordToDeque(word);
        return helper(a);
    }

    private boolean helper(Deque<Character> rest) {
        if (rest.size() <= 1) {
            return true;
        }
        char a = rest.removeFirst();
        char b = rest.removeLast();
        if (a != b) {
            return false;
        }
        return helper(rest);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() <= 1) {
            return true;
        }
        Deque<Character> a = wordToDeque(word);
        return helper(a, cc);
    }

    private boolean helper(Deque<Character> rest, CharacterComparator cc) {
        if (rest.size() <= 1) {
            return true;
        }
        char a = rest.removeFirst();
        char b = rest.removeLast();
        if (!cc.equalChars(a, b)) return false;
        return helper(rest, cc);
    }
}
