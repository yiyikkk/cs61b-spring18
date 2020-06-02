import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void testEqualChars() {
        OffByN obn = new OffByN(5);
        assertTrue(obn.equalChars('a', 'f'));
        assertTrue(obn.equalChars('f', 'a'));

        assertFalse(obn.equalChars('f', 'h'));
    }
}
