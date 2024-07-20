package Day22;
import static org.junit.Assert.*;
import org.junit.Test;

public class Task3Test {
    Task3 task3 = new Task3();

    @Test
    public void testIsPalindrome() {
        assertTrue(task3.isPalindrome("madone"));
        assertFalse(task3.isPalindrome("hello"));
        assertFalse(task3.isPalindrome(null));
    }

    @Test
    public void testReverse() {
        assertEquals("olleh", task3.reverse("hello"));
        assertEquals("", task3.reverse(""));
        assertNull(task3.reverse(null));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(task3.isEmpty(""));
        assertTrue(task3.isEmpty(null));
        assertFalse(task3.isEmpty("hello"));
    }
}
